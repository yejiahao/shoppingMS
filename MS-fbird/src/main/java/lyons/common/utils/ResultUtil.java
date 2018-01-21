/*Copyright ©  2018 Lyons. All rights reserved. */
package lyons.common.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

import lyons.common.utils.enums.AccountStaEnum;

/**
 * @Description: 消息结果集
 * @ClassName: ResultMap
 * @author: lyons<zhanglei>
 * @date: 2017年1月19日 下午1:18:00
 * @version: [1.0]
 */
public class ResultUtil {
    private static Map<String, Object> resultMap = new LinkedHashMap<>();

    public ResultUtil() {
    }

    /**
     * @param object
     * @Title: putLinkedMap
     * @Description: Message 消息结果
     * @return: Map<String,Object>
     */
    public static Map<String, Object> putMessageMap(Object object) {
        resultMap.put("Message", object);
        return resultMap;
    }

    /**
     * @param object
     * @Title: putLinkedMap
     * @Description: State 消息状态
     * @return: Map<String,Object>
     */
    public static Map<String, Object> putStateMap(Object object) {
        resultMap.put("State", object);
        return resultMap;
    }

    /**
     * @param object
     * @Title: putLinkedMap
     * @Description: Url 请求地址
     * @return: Map<String,Object>
     */
    public static Map<String, Object> putUrlMap(Object object) {
        resultMap.put("Url", object);
        return resultMap;
    }

    /**
     * @Title: clearMap
     * @Description: 清空消息集
     * @return: void
     */
    public static void clearMap() {
        resultMap.clear();
    }

    /**
     * @Title: getLinkedMap
     * @Description: 返回消息集
     * @return: Map<String,Object>
     */
    public static Map<String, Object> getLinkedMap() {
        return resultMap;
    }

    /**
     * @param message
     * @return
     * @Title: getJson
     * @Description: String -> Map("message",Object) -> json
     * @return: String(json)
     */
    public static String getJson(String message) {
        resultMap.clear();
        resultMap.put("message", message);
        return toJson(resultMap);
    }

    /**
     * @param state
     * @Title: getJson
     * @Description: int -> Map("message",Object) -> json
     * @return: String(json)
     */
    public static String getJson(int state) {
        resultMap.clear();
        resultMap.put("state", state);
        return toJson(resultMap);
    }

    /**
     * @param request
     * @Title: getUrlJson
     * @Description: after login success,return the url(json)
     * @return: String
     */
    public static String getUrlJson(HttpServletRequest request) {
        resultMap.clear();
        resultMap.put("state", AccountStaEnum.success.getState());
        resultMap.put("url", VisitorUtil.getSaveURL(request));
        return toJson(resultMap);
    }

    /**
     * @param object
     * @Title: toJson
     * @Description: object -> json
     * @return: String
     */
    public static String toJson(Object object) {
        return new Gson().toJson(object);
    }
}
