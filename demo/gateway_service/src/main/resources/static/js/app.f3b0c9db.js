(function(e){function t(t){for(var r,o,u=t[0],c=t[1],s=t[2],l=0,f=[];l<u.length;l++)o=u[l],Object.prototype.hasOwnProperty.call(a,o)&&a[o]&&f.push(a[o][0]),a[o]=0;for(r in c)Object.prototype.hasOwnProperty.call(c,r)&&(e[r]=c[r]);d&&d(t);while(f.length)f.shift()();return i.push.apply(i,s||[]),n()}function n(){for(var e,t=0;t<i.length;t++){for(var n=i[t],r=!0,o=1;o<n.length;o++){var u=n[o];0!==a[u]&&(r=!1)}r&&(i.splice(t--,1),e=c(c.s=n[0]))}return e}var r={},o={app:0},a={app:0},i=[];function u(e){return c.p+"js/"+({}[e]||e)+"."+{"chunk-658f72a6":"2368116d","chunk-7b98ff5b":"1de806ce","chunk-8333b140":"b7afba18","chunk-85426e24":"5f0f70a1"}[e]+".js"}function c(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,c),n.l=!0,n.exports}c.e=function(e){var t=[],n={"chunk-658f72a6":1,"chunk-7b98ff5b":1,"chunk-8333b140":1,"chunk-85426e24":1};o[e]?t.push(o[e]):0!==o[e]&&n[e]&&t.push(o[e]=new Promise((function(t,n){for(var r="css/"+({}[e]||e)+"."+{"chunk-658f72a6":"ca8d8f32","chunk-7b98ff5b":"417bfe22","chunk-8333b140":"098633e9","chunk-85426e24":"4857f273"}[e]+".css",a=c.p+r,i=document.getElementsByTagName("link"),u=0;u<i.length;u++){var s=i[u],l=s.getAttribute("data-href")||s.getAttribute("href");if("stylesheet"===s.rel&&(l===r||l===a))return t()}var f=document.getElementsByTagName("style");for(u=0;u<f.length;u++){s=f[u],l=s.getAttribute("data-href");if(l===r||l===a)return t()}var d=document.createElement("link");d.rel="stylesheet",d.type="text/css",d.onload=t,d.onerror=function(t){var r=t&&t.target&&t.target.src||a,i=new Error("Loading CSS chunk "+e+" failed.\n("+r+")");i.code="CSS_CHUNK_LOAD_FAILED",i.request=r,delete o[e],d.parentNode.removeChild(d),n(i)},d.href=a;var h=document.getElementsByTagName("head")[0];h.appendChild(d)})).then((function(){o[e]=0})));var r=a[e];if(0!==r)if(r)t.push(r[2]);else{var i=new Promise((function(t,n){r=a[e]=[t,n]}));t.push(r[2]=i);var s,l=document.createElement("script");l.charset="utf-8",l.timeout=120,c.nc&&l.setAttribute("nonce",c.nc),l.src=u(e);var f=new Error;s=function(t){l.onerror=l.onload=null,clearTimeout(d);var n=a[e];if(0!==n){if(n){var r=t&&("load"===t.type?"missing":t.type),o=t&&t.target&&t.target.src;f.message="Loading chunk "+e+" failed.\n("+r+": "+o+")",f.name="ChunkLoadError",f.type=r,f.request=o,n[1](f)}a[e]=void 0}};var d=setTimeout((function(){s({type:"timeout",target:l})}),12e4);l.onerror=l.onload=s,document.head.appendChild(l)}return Promise.all(t)},c.m=e,c.c=r,c.d=function(e,t,n){c.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},c.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},c.t=function(e,t){if(1&t&&(e=c(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(c.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)c.d(n,r,function(t){return e[t]}.bind(null,r));return n},c.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return c.d(t,"a",t),t},c.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},c.p="/",c.oe=function(e){throw console.error(e),e};var s=window["webpackJsonp"]=window["webpackJsonp"]||[],l=s.push.bind(s);s.push=t,s=s.slice();for(var f=0;f<s.length;f++)t(s[f]);var d=l;i.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"36b4":function(e,t,n){"use strict";n("e849")},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var r=n("2b0e"),o=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("el-container",[n("el-header",[n("title-header",{key:e.timer})],1),n("el-main",[n("router-view",{on:{"update-timer":e.updateTimer}})],1),n("el-footer",[e._v("Footer")])],1)],1)},a=[],i=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("nav",[n("el-row",[n("el-col",{attrs:{span:18}},[n("div",{staticClass:"navbar-header"},[n("router-link",{attrs:{to:"/"}},[e._v("网上书城")])],1)]),n("el-col",{attrs:{span:6}},[n("el-menu",{attrs:{mode:"horizontal"}},[e.isLogin?n("el-submenu",{attrs:{index:"1"}},[n("template",{slot:"title"},[e._v(e._s(e.username))]),n("el-menu-item",{attrs:{index:"1-1"}},[n("router-link",{attrs:{to:"/personal"}},[e._v("个人中心")])],1),n("el-menu-item",{attrs:{index:"1-2"}},[n("a",{on:{click:e.onLogout}},[e._v("退出登录")])])],2):n("el-menu-item",{attrs:{index:"1"}},[n("el-button",[n("a",{on:{click:e.onLogin}},[e._v("login")])])],1)],1)],1)],1)],1)},u=[],c={name:"TitleHeader",data:function(){return{username:"",isLogin:!1}},mounted:function(){var e=this;setTimeout((function(){var t=e.$keycloak.token;console.log("token="+t),t&&e.$keycloak.loadUserProfile().then((function(t){console.log(t),e.username=t.username,e.isLogin=!0,window.sessionStorage.setItem("username",t.username)}))}),500);var t=window.sessionStorage.getItem("username");console.log("username="+t),null!==t&&(this.username=t,this.isLogin=!0)},methods:{onLogin:function(){this.$keycloak.login()},onLogout:function(){this.$keycloak.logoutFn({redirectUri:"/"}),window.sessionStorage.removeItem("username")}}},s=c,l=(n("dcfc"),n("2877")),f=Object(l["a"])(s,i,u,!1,null,"151ea582",null),d=f.exports,h={components:{TitleHeader:d},data:function(){return{timer:""}},methods:{updateTimer:function(){this.timer=(new Date).getTime()}}},p=h,m=(n("5c0b"),Object(l["a"])(p,o,a,!1,null,null,null)),b=m.exports,g=(n("d3b7"),n("3ca3"),n("ddb0"),n("8c4f")),v=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"index"},[n("section",[n("el-carousel",{attrs:{height:"300px"}},e._l(e.newList,(function(t){return n("el-carousel-item",{key:t.id},[n("h3",{staticClass:"small"},[n("h1",[e._v(e._s(t.title))]),n("p",[e._v(e._s(t.mAbstract))])])])})),1)],1),n("main",e._l(e.bookList,(function(e){return n("div",{key:e.title},[n("book-item",{attrs:{title:e.title,mAbstract:e.mabstract,imagePath:e.imagePath}})],1)})),0)])},k=[],y=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("el-row",[n("el-col",{staticStyle:{"text-align":"center"},attrs:{span:6}},[n("img",{staticClass:"center-block",attrs:{src:e.imagePath,height:"200"}})]),n("el-col",{attrs:{span:18}},[n("h3",[n("router-link",{attrs:{to:"/abstract/"+e.title}},[e._v(e._s(e.title))])],1),n("p",{staticClass:"abstract"},[e._v(e._s(e.mAbstract))])])],1)},_=[],w={name:"BookItem",props:{title:String,mAbstract:String,imagePath:String}},L=w,x=(n("36b4"),Object(l["a"])(L,y,_,!1,null,"4e7f90ae",null)),S=x.exports,O={components:{BookItem:S},data:function(){return{newList:[{id:0,title:"新书上架：算法导论",mAbstract:"《算法导论》自第一版出版以来，已经成为世界范围内广泛使用的大学教材和专业人员的标准参考手册。"},{id:1,title:"新书上架：机器学习",mAbstract:"机器学习是计算机科学与人工智能的重要分支领域. 本书作为该领域的入门教材，在内容上尽可能涵盖机器学习基础知识的各方面。"}],bookList:[]}},mounted:function(){this.getBookList()},methods:{getBookList:function(){var e=this;this.$http.get("/books").then((function(t){e.bookList=t.data.data}))}}},j=O,P=(n("e5b2"),Object(l["a"])(j,v,k,!1,null,"b76426de",null)),E=P.exports;r["default"].use(g["a"]);var T=[{path:"/",component:E},{path:"/login",component:function(){return n.e("chunk-658f72a6").then(n.bind(null,"a55b"))}},{path:"/personal",component:function(){return n.e("chunk-85426e24").then(n.bind(null,"90ab"))}},{path:"/abstract/:title",component:function(){return n.e("chunk-8333b140").then(n.bind(null,"8b47"))}},{path:"/preview/:title",component:function(){return n.e("chunk-7b98ff5b").then(n.bind(null,"5b0b"))}}],$=new g["a"]({mode:"history",base:"/",routes:T});$.beforeEach((function(e,t,n){var o=r["default"].prototype.$keycloak.token;"/personal"!==e.path||o||r["default"].prototype.$keycloak.login(),n()}));var A=$,C=n("2f62");r["default"].use(C["a"]);var B=new C["a"].Store({state:{},mutations:{},actions:{},modules:{}}),I=n("5c96"),N=n.n(I),M=(n("0fae"),n("bc3a")),U=n.n(M),q=n("4cc4"),D=n.n(q);r["default"].use(N.a),r["default"].config.productionTip=!1,r["default"].prototype.$http=U.a,U.a.interceptors.request.use((function(e){var t=r["default"].prototype.$keycloak.token;return t&&(e.headers.Authorization="Bearer "+t),e})),r["default"].use(D.a,{init:{onLoad:"check-sso"},config:{url:"http://localhost:8180/auth",realm:"product_service",clientId:"vue-front"},logout:{redirectUri:"http://"+window.location.host+"/"},onReady:function(e){}}),new r["default"]({router:A,store:B,render:function(e){return e(b)}}).$mount("#app")},"5c0b":function(e,t,n){"use strict";n("9c0c")},"9c0c":function(e,t,n){},d7e6:function(e,t,n){},dcfc:function(e,t,n){"use strict";n("d7e6")},e5b2:function(e,t,n){"use strict";n("edfc")},e849:function(e,t,n){},edfc:function(e,t,n){}});
//# sourceMappingURL=app.f3b0c9db.js.map