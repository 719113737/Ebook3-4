(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-85426e24"],{"0bba":function(t,e,i){"use strict";i("ebb3")},"90ab":function(t,e,i){"use strict";i.r(e);var o=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",{staticClass:"personal"},[i("el-tabs",{attrs:{"tab-position":"left",type:"border-card"}},[i("el-tab-pane",{attrs:{label:"账户安全"}},[i("h1",[t._v("账户安全")]),i("h2",[t._v("个人信息")]),i("el-form",{ref:"form",attrs:{model:t.form,"label-width":"80px"}},[i("el-form-item",{attrs:{label:"邮箱"}},[i("el-input",{model:{value:t.form.email,callback:function(e){t.$set(t.form,"email",e)},expression:"form.email"}})],1),i("el-form-item",[i("el-button",{attrs:{type:"primary"},on:{click:t.onSubmit}},[t._v("修改")])],1)],1)],1),i("el-tab-pane",{attrs:{label:"我的收藏"}},[i("h1",[t._v("我的收藏")]),i("div",{staticClass:"collection-container"},t._l(t.collectionList,(function(e){return i("div",{key:e.title,staticClass:"collection-block"},[i("img",{attrs:{src:e.imagePath,alt:"",width:"240px",height:"300px"}}),i("div",{staticClass:"title"},[i("router-link",{attrs:{to:"/abstract/"+e.title}},[t._v(t._s(e.title))])],1)])})),0)])],1)],1)},s=[],a={data:function(){return{username:"",form:{email:""},collectionList:[]}},mounted:function(){this.getUserInfo(),this.getCollection()},methods:{getUserInfo:function(){var t=this;this.username=window.sessionStorage.getItem("username"),this.$keycloak.loadUserProfile().then((function(e){console.log(e),t.form.email=e.email}))},getCollection:function(){var t=this;this.$http.get("/collect/"+this.username+"/collections").then((function(e){t.collectionList=e.data.data}))},onSubmit:function(){var t=this;this.$http.post("/user/"+this.username,this.form).then((function(e){var i=e.data;200===i.code?t.$message.success("修改成功"):t.$message.error("修改失败")}))}}},n=a,l=(i("0bba"),i("2877")),r=Object(l["a"])(n,o,s,!1,null,"3bbbf902",null);e["default"]=r.exports},ebb3:function(t,e,i){}}]);
//# sourceMappingURL=chunk-85426e24.5f0f70a1.js.map