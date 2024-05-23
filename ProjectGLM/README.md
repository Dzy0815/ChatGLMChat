# ChatGLM对话API

> 以vue.js和springboot实现和ChatGLM3-6B大模型的前后端沟通

## Vue前端

+ 在config/index.js里面的proxyTable设置代理来解决跨域的问题
``` JavaScript
proxyTable: {
      '/api': {
      target: 'http://localhost:8080', // 你的后端服务地址
      changeOrigin: true,
      pathRewrite: {
        '^/api': ''
      }
    }
}
```

## SpringBoot后端

>主要负责像后端发送json格式的请求对接API