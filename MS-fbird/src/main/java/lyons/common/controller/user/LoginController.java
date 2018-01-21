/*Copyright ©  2018 Lyons. All rights reserved. */
package lyons.common.controller.user;

import lyons.common.controller.BaseController;
import lyons.common.exception.user.UserException;
import lyons.common.model.user.UUser;
import lyons.common.service.goods.GoodsService;
import lyons.common.utils.ResultUtil;
import lyons.common.utils.VisitorUtil;
import lyons.common.utils.enums.AccountStaEnum;
import lyons.core.shiro.token.TokenManager;
import org.apache.shiro.authc.DisabledAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 注册、登录、退出
 * @ClassName: LoginController
 * @author: lyons<zhanglei>
 * @date: 2017年1月5日 下午8:25:47
 * @version: [1.0]
 */
@Controller
public class LoginController extends BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private GoodsService goodsService;
    
/*    @RequestMapping(value = "/")
    public String requestAll() {
        LOG.info("\n\n / ==> 重定向至首页 \n");
        return "redirect:/index";
    }*/

    @RequestMapping(value = "/index")
    public void index(Model model) {
        LOG.info("\n\n /index ==> 跳转到首页 \n");
        model.addAttribute("goodsList", goodsService.findAllGoods());
    }

    @RequestMapping("/login")
    public String loginGet() {
        LOG.info("\n\n /login ==> GET 请求登录 \n");
        return "admin/login";
    }

    /**
     * @param uuser
     * @param request
     * @Title: loginPost
     * @Description: 登录
     * @return: String
     */
    @RequestMapping(value = "/admin/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String loginPost(UUser uuser, HttpServletRequest request) {
        try {
            TokenManager.login(uuser);
            LOG.info("\n\n " + VisitorUtil.getIpAddress(request) + " *====登录成功====* \n");
            return ResultUtil.getUrlJson(request);
        } catch (UserException e) {
            LOG.error("\n\n ==> 请求空值: " + e + " <==\n");
            return ResultUtil.getJson(e.getMessage());
        } catch (DisabledAccountException e) {
            LOG.error("\n\n ==> 账号未启用 <== \n");
            return ResultUtil.getJson(AccountStaEnum.disabled.getInfo());
        } catch (Exception e) {
            LOG.error("\n\n ==> 账号或密码错误: " + e + " <==\n");
            return ResultUtil.getJson(AccountStaEnum.failed.getInfo());
        }
    }

    /**
     * @Title: logout
     * @Description: 用户退出
     * @return: String
     */
    @RequestMapping("/admin/logout")
    public String logout() {
        try {
            TokenManager.logout();
            LOG.info("\n\n ==> 账号退出成功 <== \n");
        } catch (Exception e) {
            LOG.error("\n\n ==> 退出错误: " + e + " <== \n");
        }
        return "admin/login";
    }

}
