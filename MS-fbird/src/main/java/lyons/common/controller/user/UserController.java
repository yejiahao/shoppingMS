/*Copyright ©  2018 Lyons. All rights reserved. */
package lyons.common.controller.user;

import lyons.common.exception.user.UserException;
import lyons.common.model.user.UUser;
import lyons.common.utils.ResultUtil;
import lyons.common.utils.VisitorUtil;
import lyons.common.utils.enums.AccountStaEnum;
import lyons.core.shiro.token.ShiroDbRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 用户信息维护
 * @ClassName: UserController
 * @author: lyons<zhanglei>
 * @date: 2017年2月10日 下午9:27:19
 * @version: [1.0]
 */
@Controller
public class UserController {
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ShiroDbRealm shiroDbRealm;

    @RequestMapping(value = "/admin/register")
    public String register() {
        return "admin/register";
    }

    /**
     * @Title: registerSuccess
     * @Description: 注册成功
     * @return: String
     */
    @RequestMapping(value = "/registerSuccess")
    public String registerSuccess() {
        return "success/200";
    }

    /**
     * @param uuser
     * @param request
     * @Title: loginPost
     * @Description: 用户注册
     * @return: String
     */
    @RequestMapping(value = "/admin/register", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String registerPost(UUser uuser, HttpServletRequest request) {
        try {
            /* 安全检查、正式注册  未进行邮箱安全检查 */
            if (VisitorUtil.isSecurity(uuser)) {
                 /* 正在注册 */
                shiroDbRealm.registering(uuser);
            }
            LOG.info("\n\n " + VisitorUtil.getIpAddress(request) + " *====注册成功====* \n");
            return ResultUtil.getUrlJson(request);
        } catch (UserException e) {
            LOG.error("\n\n ==> 邮箱已注册 <== \n");
            return ResultUtil.getJson(e.getMessage());
        } catch (Exception e) {
            LOG.error("\n\n ==> 注册失败: " + e + " <==\n");
            return ResultUtil.getJson(AccountStaEnum.registerFailed.getInfo());
        }
    }
}
