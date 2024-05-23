module.exports = {
    devServer: {
      proxy: {
        '/chatglm-api': {
          target: 'http://localhost:8080', // 你的后端服务地址
          changeOrigin: true,
          pathRewrite: {
            '^/chatglm-api': ''
          }
        }
      }
    }
  }
  