package com.hunangongchengxueyuan.community.community.controller;
import com.hunangongchengxueyuan.community.community.entity.Page;
import com.hunangongchengxueyuan.community.community.service.DiscussPostService;
import com.hunangongchengxueyuan.community.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hunangongchengxueyuan.community.community.entity.DiscussPost;
import com.hunangongchengxueyuan.community.community.entity.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page) {
        //SpingMVC会自动实列化Model和Page
        page.getRows(discussPostService.findDiscussPostRows(0));
        page.getPath("/index");
        List<DiscussPost> list = discussPostService.findDiscussPosts(0,0,0);
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post : list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);
                discussPosts.add(map);
            }

        }
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }
}
















