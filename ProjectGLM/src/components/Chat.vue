<template>
<div class="slider-chat-container">
  <div class="slider-container">
      <div>
          <label id="t-label">temperature：</label>
          <vue-slider v-model="formData.temperature" :min="0" :max="1" :interval="0.01" :tooltip="'hover'" id="temperature" />
      </div>
      <div>
          <label id="p-label">p-penality：</label>
          <vue-slider v-model="formData.presencePenalty" :min="0" :max="2" :interval="0.01" :tooltip="'hover'" id="p_penality" />
      </div>
      <div>
          <label id="maxtoken-label">max token：</label>
          <vue-slider v-model="formData.maxTokens" :min="5" :max="30000" :interval="1" :tooltip="'hover'" id="maxToken" />
      </div>
    </div>
  <div class="chat-container">
    <div class="chat-box" ref="chatBox">
      <div v-for="(message, index) in formData.messages.slice(1)" :key="index" class="message" :class="{ 'user-message': message.role === 'user', 'system-message': message.role === 'system' }">
        <vue-markdown>{{ message.content }}</vue-markdown>
      </div>
    </div>
    <div class="input-container">
      <input type="text" v-model="newMessage" @keyup.enter="sendMessage" placeholder="Type your message here...">
      <button @click="sendMessage">Send</button>
    </div>
  </div>
</div>
</template>

<script>
import axios from 'axios';
import VueSlider from 'vue-slider-component';
import 'vue-slider-component/theme/default.css';
import VueMarkdown from 'vue-markdown';

export default {
  components: {
        VueSlider,
        VueMarkdown
    },
  data() {
    return {
      newMessage:'',
            formData:{
                presencePenalty:1.2,
                temperature:0.5,
                maxTokens:256,
                model:'chatglm3-6b',
                messages:[{role:'system',content:"You are ChatGLM3, a large language model trained by Zhipu.AI. Follow the user's instructions carefully. Respond using markdown."}]
            },
            responseData: null
    };
  },
  methods: {
    sendMessage() {
      if (this.newMessage.trim() !== '') {
        this.formData.messages.push({role:'user',content:this.newMessage})
        console.log(this.formData);
        this.newMessage = '';
        axios.post('/api/chatglm-api/chat',this.formData)
          .then(response => {
              console.log('Response:', response.data);
              this.responseData=response.data
              this.formData.messages.push({role:'assistant',content:this.responseData.choices[0].message.content})
              this.$nextTick(() => {
                this.scrollToBottom();
              });
          })
          .catch(error =>{
              console.error('Error:', error);
          });   
      }
    },
    scrollToBottom() {
      this.$refs.chatBox.scrollTop = this.$refs.chatBox.scrollHeight;
    }
  }
};
</script>

<style>
.slider-chat-container{
  display: flex;
}
.slider-container{
  width: 200px;
}
.chat-container {
  flex: 1;
  display: flex;
  flex-direction: column;
  height: 400px; /* 可以根据需要调整对话框的高度 */
}
.chat-box {
  flex: 1;
  overflow-y: auto; /* 当内容超出容器高度时显示滚动条 */
  padding: 20px;
  border: 1px solid black;
  margin: 10px;
}

.message {
  margin-bottom: 10px;
  padding: 5px 10px;
  border-radius: 5px;
}

.user-message {
  background-color: #DCF8C6;
  align-self: flex-end;
}

.system-message {
  background-color: #F0F0F0;
  align-self: flex-start;
}

.input-container {
  display: flex;
  padding: 10px;
}

.input-container input {
  flex: 1;
  margin-right: 10px;
}

.input-container button {
  min-width: 80px;
}
</style>
