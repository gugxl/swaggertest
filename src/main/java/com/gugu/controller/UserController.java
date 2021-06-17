package com.gugu.controller;

import com.gugu.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Administrator
 * @Classname UserController
 * @Description TODO
 * @Date 2021/2/4 23:19
 */
@Api("用户操作接口")
@Controller
@RequestMapping("/user")
public class UserController {


    @PostMapping("/list")
    @ApiOperation("用户查询")
    public List<UserVO> getOtp(@RequestBody List<UserVO> userVOS) {
        System.out.println(userVOS);
        return userVOS;
    }

    @ResponseBody
    @GetMapping("/getUserInfo/{userId}")
    public UserVO testUrlPathParam(HttpServletRequest request, @PathVariable Long userId) {
        System.out.println("通过PathVariable获取的参数userId=" + userId);
        UserVO userVO = new UserVO();
        userVO.setId(userId);
        return userVO;
    }

    @ResponseBody
    @GetMapping("/getUserInfo2")
    public UserVO testHeaderParam(HttpServletRequest request, @RequestHeader Long userId) {
        System.out.println("通过RequestHeader获取的参数userId=" + userId);
        UserVO userVO = new UserVO();
        userVO.setId(userId);
        return userVO;
    }

    @ResponseBody
    @GetMapping("/getUserInfo3")
    public UserVO testCookieParam(HttpServletRequest request, HttpServletResponse response,
                                @CookieValue Long userId) {
        System.out.println("通过CookieValue获取的参数userId=" + userId);
        UserVO userVO = new UserVO();
        userVO.setId(userId);
        return userVO;
    }

    @ResponseBody
    @GetMapping("/getUserInfo4")
    public UserVO testRequestParam(HttpServletRequest request,
                                 @RequestParam(value = "userId", required = true, defaultValue = "0") Long userId) {
        System.out.println("通过RequestParam获取的参数userId=" + userId);
        UserVO userVO = new UserVO();
        userVO.setId(userId);
        return userVO;
    }

    @ResponseBody
    @PostMapping("/getUserInfo5")
    public UserVO testRequestBody(HttpServletRequest request, @RequestBody UserVO userVO){
        System.out.println("通过RequestBody获取的参数userVO=" + userVO.toString());
        return userVO;
    }
}
