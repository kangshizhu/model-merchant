JwtUtil根据password 和username生成token  存入redis 用jwt验证
shiroConfig拦截 jwtFilter（ getSubject(request, response).login(jwtToken);）启动认证（shiroReaml） 认证通过放行
@RequiresRoles("DDDD") 是权限验证  shiroReaml 的doGetAuthorizationInfo



swagger2文档地址
http://localhost:8082/jeecg-boot/doc.html