<template>
    <div>
    <form>
        <div>
        <div class="form-group">
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
            </div><!--控制模型的温度，最小的累积概率，最长token的滑块-->
            <div>
                <label for="usertext">用户：</label>
                <input type="text" id="usertext" v-model="usertext"/>
            </div><!--接受用户输入-->
        </div>
        <button @click.prevent="handleSubmit"> 提交</button>
        </div>
    </form>

    <div class="response">
        <div v-if="responseData">
            <p>{{ responseData.result }}</p>
            <!--接受返回值，如果没有返回值就显示Loading...-->
        </div>
        <div v-else>
            <p>Loading...</p>
        </div>
    </div>
    </div>
    

    
</template>

<script>
import axios from 'axios';
import VueSlider from 'vue-slider-component';
import 'vue-slider-component/theme/default.css';
//导入axios用于发送json请求，导入VueSlider实现滑块

export default {
    components: {
        VueSlider
    },
    data(){
        return{
            usertext:'',
            formData:{
                presencePenalty:1.2,
                temperature:0.5,
                maxTokens:256,
                model:'chatglm3-6b',
                tool_choice : 'auto',
                stream:true,
                messages:[],
                echo:false,
                tools:[
                    {
                        type: "function",
                        function:{    
                        name: "get_current_weather",
                        description: "Get the current weather in a given location",
                        parameters: {
                            type: "object",
                            properties: {
                                location:{
                                    type:"string",
                                    description: "The city and state, e.g. San Francisco, CA",
                                },
                                unit: {type:"string",enum:["celsius", "fahrenheit"]},
                            },                        
                            required: ["location"],
                        }
                    }
                    }
                 ]
            },
            responseData: null
        };//构建formData的数组，首先在messages里添加System的默认prompt
    },
    methods:{
        async handleSubmit(){
            this.formData.messages.push({role:'user',content:this.usertext});
            console.log(this.formData);
            axios.post('/api/chatglm-api/tools',this.formData)
            .then(response => {
                console.log('Response:', response.data);
                this.responseData=response.data
                this.formData.usertext='';
            })
            .catch(error =>{
                console.error('Error:', error);
            });
        }//提交到代理服务器的指定位置
    }
};


</script>

<style>
.slider-container {
  width: 300px;
  margin-left: 20px;
  
}
#t-label{
    margin-left:0;
    text-align: left;
}
#usertext{
    height: 200px;
    width: 500px;
}
.form-group{
    display: flex; /* 使用 Flexbox 布局 */
    align-items: center; /* 垂直居中对齐 */
    margin-bottom: 10px; /* 可选：设置表单组之间的间距 */
}
.response{
    height: 200px;
    width: 500px;
    margin: 0 auto;
}
</style>