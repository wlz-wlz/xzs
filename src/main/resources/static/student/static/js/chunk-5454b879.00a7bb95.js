(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5454b879"],{2017:function(t,e,o){"use strict";var s=o("cafe"),n=o.n(s);n.a},"5fbe":function(t,e,o){t.exports=o.p+"static/img/logo2.745fd978.png"},"6edf":function(t,e,o){},"9ed6":function(t,e,o){"use strict";o.r(e);var s=function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{staticClass:"lowin  lowin-blue"},[t._m(0),o("div",{staticClass:"lowin-wrapper"},[o("div",{staticClass:"lowin-box lowin-login"},[o("div",{staticClass:"lowin-box-inner"},[o("el-form",{ref:"loginForm",attrs:{model:t.loginForm,rules:t.loginRules}},[o("p",[t._v("学之思考试系统")]),o("div",{staticClass:"lowin-group"},[o("label",[t._v("用户名 ")]),o("el-input",{ref:"userName",staticClass:"lowin-input",attrs:{placeholder:"用户名",name:"userName",type:"text",tabindex:"1","auto-complete":"on"},model:{value:t.loginForm.userName,callback:function(e){t.$set(t.loginForm,"userName",e)},expression:"loginForm.userName"}})],1),o("div",{staticClass:"lowin-group password-group"},[o("label",[t._v("密码 "),o("a",{staticClass:"forgot-link",attrs:{href:"#"}},[t._v("忘记密码?")])]),o("el-input",{key:t.passwordType,ref:"password",staticClass:"lowin-input",attrs:{type:t.passwordType,placeholder:"密码",name:"password",tabindex:"2","auto-complete":"on"},on:{blur:function(e){t.capsTooltip=!1}},nativeOn:{keyup:[function(e){return t.checkCapslock(e)},function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.handleLogin(e)}]},model:{value:t.loginForm.password,callback:function(e){t.$set(t.loginForm,"password",e)},expression:"loginForm.password"}})],1),o("el-button",{staticClass:"lowin-btn login-btn",attrs:{loading:t.loading,type:"text"},nativeOn:{click:function(e){return e.preventDefault(),t.handleLogin(e)}}},[t._v("登录")]),o("div",{staticClass:"text-foot"},[t._v(" 还没有账号? "),o("router-link",{staticClass:"register-link",attrs:{to:"/register"}},[t._v(" 注册 ")])],1)],1)],1)])]),t._m(1)])},n=[function(){var t=this,e=t.$createElement,s=t._self._c||e;return s("div",{staticClass:"lowin-brand"},[s("img",{staticStyle:{"margin-top":"12px"},attrs:{src:o("5fbe"),alt:"logo"}})])},function(){var t=this,e=t.$createElement,o=t._self._c||e;return o("div",{staticClass:"account-foot-copyright"},[o("span",[t._v("Copyright © 2020 武汉思维跳跃科技有限公司 版权所有")])])}],i=o("5530"),a=o("2f62"),r=o("7ded"),l={name:"Login",data:function(){var t=function(t,e,o){e.length<5?o(new Error("用户名不能少于5个字符")):o()},e=function(t,e,o){e.length<5?o(new Error("密码不能少于5个字符")):o()};return{loginForm:{userName:"",password:"",remember:!1},loginRules:{userName:[{required:!0,trigger:"blur",validator:t}],password:[{required:!0,trigger:"blur",validator:e}]},passwordType:"password",capsTooltip:!1,loading:!1,showDialog:!1}},created:function(){},mounted:function(){""===this.loginForm.userName?this.$refs.userName.focus():""===this.loginForm.password&&this.$refs.password.focus()},destroyed:function(){},methods:Object(i["a"])({checkCapslock:function(){var t=arguments.length>0&&void 0!==arguments[0]?arguments[0]:{},e=t.shiftKey,o=t.key;o&&1===o.length&&(this.capsTooltip=!!(e&&o>="a"&&o<="z"||!e&&o>="A"&&o<="Z")),"CapsLock"===o&&!0===this.capsTooltip&&(this.capsTooltip=!1)},showPwd:function(){var t=this;"password"===this.passwordType?this.passwordType="":this.passwordType="password",this.$nextTick((function(){t.$refs.password.focus()}))},handleLogin:function(){var t=this,e=this;this.$refs.loginForm.validate((function(o){if(!o)return!1;t.loading=!0,r["a"].login(t.loginForm).then((function(t){t&&1===t.code?(e.setUserName(e.loginForm.userName),e.$router.push({path:"/"})):(e.loading=!1,e.$message.error(t.message))})).catch((function(t){e.loading=!1}))}))}},Object(a["d"])("user",["setUserName"]))},c=l,u=(o("2017"),o("ea02"),o("2877")),p=Object(u["a"])(c,s,n,!1,null,"27da0a50",null);e["default"]=p.exports},cafe:function(t,e,o){},ea02:function(t,e,o){"use strict";var s=o("6edf"),n=o.n(s);n.a}}]);