(function(t){function e(e){for(var a,o,l=e[0],i=e[1],c=e[2],d=0,f=[];d<l.length;d++)o=l[d],Object.prototype.hasOwnProperty.call(s,o)&&s[o]&&f.push(s[o][0]),s[o]=0;for(a in i)Object.prototype.hasOwnProperty.call(i,a)&&(t[a]=i[a]);u&&u(e);while(f.length)f.shift()();return r.push.apply(r,c||[]),n()}function n(){for(var t,e=0;e<r.length;e++){for(var n=r[e],a=!0,l=1;l<n.length;l++){var i=n[l];0!==s[i]&&(a=!1)}a&&(r.splice(e--,1),t=o(o.s=n[0]))}return t}var a={},s={app:0},r=[];function o(e){if(a[e])return a[e].exports;var n=a[e]={i:e,l:!1,exports:{}};return t[e].call(n.exports,n,n.exports,o),n.l=!0,n.exports}o.m=t,o.c=a,o.d=function(t,e,n){o.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:n})},o.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},o.t=function(t,e){if(1&e&&(t=o(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var n=Object.create(null);if(o.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var a in t)o.d(n,a,function(e){return t[e]}.bind(null,a));return n},o.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return o.d(e,"a",e),e},o.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},o.p="/board/qna/";var l=window["webpackJsonp"]=window["webpackJsonp"]||[],i=l.push.bind(l);l.push=e,l=l.slice();for(var c=0;c<l.length;c++)e(l[c]);var u=i;r.push([0,"chunk-vendors"]),n()})({0:function(t,e,n){t.exports=n("56d7")},4678:function(t,e,n){var a={"./af":"2bfb","./af.js":"2bfb","./ar":"8e73","./ar-dz":"a356","./ar-dz.js":"a356","./ar-kw":"423e","./ar-kw.js":"423e","./ar-ly":"1cfd","./ar-ly.js":"1cfd","./ar-ma":"0a84","./ar-ma.js":"0a84","./ar-sa":"8230","./ar-sa.js":"8230","./ar-tn":"6d83","./ar-tn.js":"6d83","./ar.js":"8e73","./az":"485c","./az.js":"485c","./be":"1fc1","./be.js":"1fc1","./bg":"84aa","./bg.js":"84aa","./bm":"a7fa","./bm.js":"a7fa","./bn":"9043","./bn.js":"9043","./bo":"d26a","./bo.js":"d26a","./br":"6887","./br.js":"6887","./bs":"2554","./bs.js":"2554","./ca":"d716","./ca.js":"d716","./cs":"3c0d","./cs.js":"3c0d","./cv":"03ec","./cv.js":"03ec","./cy":"9797","./cy.js":"9797","./da":"0f14","./da.js":"0f14","./de":"b469","./de-at":"b3eb","./de-at.js":"b3eb","./de-ch":"bb71","./de-ch.js":"bb71","./de.js":"b469","./dv":"598a","./dv.js":"598a","./el":"8d47","./el.js":"8d47","./en-au":"0e6b","./en-au.js":"0e6b","./en-ca":"3886","./en-ca.js":"3886","./en-gb":"39a6","./en-gb.js":"39a6","./en-ie":"e1d3","./en-ie.js":"e1d3","./en-il":"7333","./en-il.js":"7333","./en-in":"ec2e","./en-in.js":"ec2e","./en-nz":"6f50","./en-nz.js":"6f50","./en-sg":"b7e9","./en-sg.js":"b7e9","./eo":"65db","./eo.js":"65db","./es":"898b","./es-do":"0a3c","./es-do.js":"0a3c","./es-us":"55c9","./es-us.js":"55c9","./es.js":"898b","./et":"ec18","./et.js":"ec18","./eu":"0ff2","./eu.js":"0ff2","./fa":"8df4","./fa.js":"8df4","./fi":"81e9","./fi.js":"81e9","./fil":"d69a","./fil.js":"d69a","./fo":"0721","./fo.js":"0721","./fr":"9f26","./fr-ca":"d9f8","./fr-ca.js":"d9f8","./fr-ch":"0e49","./fr-ch.js":"0e49","./fr.js":"9f26","./fy":"7118","./fy.js":"7118","./ga":"5120","./ga.js":"5120","./gd":"f6b4","./gd.js":"f6b4","./gl":"8840","./gl.js":"8840","./gom-deva":"aaf2","./gom-deva.js":"aaf2","./gom-latn":"0caa","./gom-latn.js":"0caa","./gu":"e0c5","./gu.js":"e0c5","./he":"c7aa","./he.js":"c7aa","./hi":"dc4d","./hi.js":"dc4d","./hr":"4ba9","./hr.js":"4ba9","./hu":"5b14","./hu.js":"5b14","./hy-am":"d6b6","./hy-am.js":"d6b6","./id":"5038","./id.js":"5038","./is":"0558","./is.js":"0558","./it":"6e98","./it-ch":"6f12","./it-ch.js":"6f12","./it.js":"6e98","./ja":"079e","./ja.js":"079e","./jv":"b540","./jv.js":"b540","./ka":"201b","./ka.js":"201b","./kk":"6d79","./kk.js":"6d79","./km":"e81d","./km.js":"e81d","./kn":"3e92","./kn.js":"3e92","./ko":"22f8","./ko.js":"22f8","./ku":"2421","./ku.js":"2421","./ky":"9609","./ky.js":"9609","./lb":"440c","./lb.js":"440c","./lo":"b29d","./lo.js":"b29d","./lt":"26f9","./lt.js":"26f9","./lv":"b97c","./lv.js":"b97c","./me":"293c","./me.js":"293c","./mi":"688b","./mi.js":"688b","./mk":"6909","./mk.js":"6909","./ml":"02fb","./ml.js":"02fb","./mn":"958b","./mn.js":"958b","./mr":"39bd","./mr.js":"39bd","./ms":"ebe4","./ms-my":"6403","./ms-my.js":"6403","./ms.js":"ebe4","./mt":"1b45","./mt.js":"1b45","./my":"8689","./my.js":"8689","./nb":"6ce3","./nb.js":"6ce3","./ne":"3a39","./ne.js":"3a39","./nl":"facd","./nl-be":"db29","./nl-be.js":"db29","./nl.js":"facd","./nn":"b84c","./nn.js":"b84c","./oc-lnc":"167b","./oc-lnc.js":"167b","./pa-in":"f3ff","./pa-in.js":"f3ff","./pl":"8d57","./pl.js":"8d57","./pt":"f260","./pt-br":"d2d4","./pt-br.js":"d2d4","./pt.js":"f260","./ro":"972c","./ro.js":"972c","./ru":"957c","./ru.js":"957c","./sd":"6784","./sd.js":"6784","./se":"ffff","./se.js":"ffff","./si":"eda5","./si.js":"eda5","./sk":"7be6","./sk.js":"7be6","./sl":"8155","./sl.js":"8155","./sq":"c8f3","./sq.js":"c8f3","./sr":"cf1e","./sr-cyrl":"13e9","./sr-cyrl.js":"13e9","./sr.js":"cf1e","./ss":"52bd","./ss.js":"52bd","./sv":"5fbd","./sv.js":"5fbd","./sw":"74dc","./sw.js":"74dc","./ta":"3de5","./ta.js":"3de5","./te":"5cbb","./te.js":"5cbb","./tet":"576c","./tet.js":"576c","./tg":"3b1b","./tg.js":"3b1b","./th":"10e8","./th.js":"10e8","./tl-ph":"0f38","./tl-ph.js":"0f38","./tlh":"cf75","./tlh.js":"cf75","./tr":"0e81","./tr.js":"0e81","./tzl":"cf51","./tzl.js":"cf51","./tzm":"c109","./tzm-latn":"b53d","./tzm-latn.js":"b53d","./tzm.js":"c109","./ug-cn":"6117","./ug-cn.js":"6117","./uk":"ada2","./uk.js":"ada2","./ur":"5294","./ur.js":"5294","./uz":"2e8c","./uz-latn":"010e","./uz-latn.js":"010e","./uz.js":"2e8c","./vi":"2921","./vi.js":"2921","./x-pseudo":"fd7e","./x-pseudo.js":"fd7e","./yo":"7f33","./yo.js":"7f33","./zh-cn":"5c3a","./zh-cn.js":"5c3a","./zh-hk":"49ab","./zh-hk.js":"49ab","./zh-mo":"3a6c","./zh-mo.js":"3a6c","./zh-tw":"90ea","./zh-tw.js":"90ea"};function s(t){var e=r(t);return n(e)}function r(t){if(!n.o(a,t)){var e=new Error("Cannot find module '"+t+"'");throw e.code="MODULE_NOT_FOUND",e}return a[t]}s.keys=function(){return Object.keys(a)},s.resolve=r,t.exports=s,s.id="4678"},"56d7":function(t,e,n){"use strict";n.r(e);n("e260"),n("e6cf"),n("cca6"),n("a79d");var a=n("2b0e"),s=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"container",attrs:{id:"app"}},[n("h2",[t._v("QnA 게시판")]),n("router-view")],1)},r=[],o={name:"App"},l=o,i=n("2877"),c=Object(i["a"])(l,s,r,!1,null,null,null),u=c.exports,d=n("8c4f"),f=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[t.items.length?n("div",[n("table",{staticClass:"table table-bordered table-condensed",attrs:{align:"center"}},[n("colgroup",[n("col",{style:{width:"5%"}}),n("col",{style:{width:"50%"}}),n("col",{style:{width:"10%"}}),n("col",{style:{width:"25%"}})]),t._m(0),t._l(t.items,(function(e,a){return n("tr",{key:a+"_items",attrs:{align:"center"}},[n("td",[t._v(t._s(e.qnaNo))]),n("td",[n("a",{attrs:{href:"#"+e.qnaNo},on:{click:function(n){return t.$router.push({name:"read",params:{no:e.qnaNo}})}}},[t._v(t._s(e.qnaTitle))])]),n("td",[t._v(t._s(e.qnaMemid))]),n("td",[t._v(t._s(t.getFormatDate(e.qnaDatetime)))])])}))],2)]):n("div",[t._v("글이 없습니다.")]),t.user?n("div",{staticClass:"text-right"},[n("button",{staticClass:"btn btn-primary",on:{click:t.movePage}},[t._v("등록")])]):t._e()])},p=[function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("tr",[n("th",[t._v("번호")]),n("th",[t._v("제목")]),n("th",[t._v("작성자")]),n("th",[t._v("날짜")])])}],h=n("bc3a"),m=n.n(h),b=n("c1df"),v=n.n(b),j={name:"List",data:function(){return{items:[],user:[]}},created:function(){var t=this;this.user=JSON.parse(localStorage.getItem("userinfo")),console.log(this.user),this.user?m.a.get("http://localhost:9999/board/qna").then((function(e){var n=e.data;t.items=n,console.log(t.items)})):(alert("접근 권한이 없습니다."),location.href="/")},methods:{getFormatDate:function(t){return v()(new Date(t)).format("YYYY.MM.DD")},movePage:function(){this.$router.push("/createQ")}}},y=j,q=Object(i["a"])(y,f,p,!1,null,null,null),g=q.exports,_=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("table",{staticClass:"table table-bordered w-50"},[n("tr",[n("th",[t._v("번호")]),n("td",[t._v(t._s(t.item.qnaNo))])]),n("tr",[n("th",[t._v("글쓴이")]),n("td",[t._v(t._s(t.item.qnaMemid))])]),n("tr",[n("th",[t._v("제목")]),n("td",[t._v(t._s(t.item.qnaTitle))])]),n("tr",[n("th",[t._v("날짜")]),n("td",[t._v(t._s(t.getFormatDate(t.item.qnaDatetime)))])]),n("tr",[n("td",{attrs:{colspan:"2"}},[t._v(" "+t._s(t.item.content)+" ")])])]),n("br"),n("div",{staticClass:"text-center"},[n("router-link",{attrs:{to:"/list"}},[n("button",{staticClass:"btn btn-primary"},[t._v("목록")])]),t.user.no==t.item.qnaMemno||1==t.user.type?n("router-link",{attrs:{to:"/updateQ?no="+t.item.qnaNo}},[n("button",{staticClass:"btn btn-primary"},[t._v("수정")])]):t._e(),t.user.no==t.item.qnaMemno||1==t.user.type?n("router-link",{attrs:{to:"/deleteQ/"+t.item.qnaNo}},[n("button",{staticClass:"btn btn-primary"},[t._v("삭제")])]):t._e(),1==t.user.type?n("router-link",{attrs:{to:"/createA?no="+t.item.qnaNo}},[n("button",{staticClass:"btn btn-primary"},[t._v("답변 등록")])]):t._e()],1),t.user&&t.item.reply>0?n("div",{attrs:{id:"answer"}},[n("br"),n("br"),n("table",{staticClass:"table table-bordered w-50"},[n("tr",[n("th",[t._v("답변자")]),n("td",[t._v(t._s(t.item.replyMemid))])]),n("tr",[n("th",[t._v("답변 날짜")]),n("td",[t._v(t._s(t.getFormatDate(t.item.replyDatetime)))])]),n("tr",[n("td",{attrs:{colspan:"2"}},[t._v(" "+t._s(t.item.replyContent)+" ")])])]),n("br"),1==t.user.type?n("div",{staticClass:"text-center"},[n("router-link",{attrs:{to:"/updateA?no="+t.item.qnaNo}},[n("button",{staticClass:"btn btn-primary"},[t._v("수정")])]),n("router-link",{attrs:{to:"/deleteA/"+t.item.qnaNo}},[n("button",{staticClass:"btn btn-primary"},[t._v("삭제")])])],1):t._e()]):t._e()])},C=[],k={name:"Read",data:function(){return{item:{},user:[]}},created:function(){var t=this;this.user=JSON.parse(localStorage.getItem("userinfo")),this.user?m.a.get("http://localhost:9999/board/qna/".concat(this.$route.params.no)).then((function(e){var n=e.data;t.item=n,console.log(t.item)})):(alert("접근 권한이 없습니다."),location.href="/")},methods:{getFormatDate:function(t){return v()(new Date(t)).format("YYYY.MM.DD HH:mm:ss")}}},x=k,w=Object(i["a"])(x,_,C,!1,null,null,null),N=w.exports,$=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"qnaTitle"}},[t._v("제목")]),n("input",{directives:[{name:"model",rawName:"v-model",value:t.qnaTitle,expression:"qnaTitle"}],ref:"qnaTitle",staticClass:"form-control",attrs:{type:"text",id:"qnaTitle",placeholder:"제목을 입력하세요"},domProps:{value:t.qnaTitle},on:{input:function(e){e.target.composing||(t.qnaTitle=e.target.value)}}})]),n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"qnaContent"}},[t._v("내용")]),n("textarea",{directives:[{name:"model",rawName:"v-model",value:t.qnaContent,expression:"qnaContent"}],ref:"qnaContent",staticClass:"form-control",attrs:{type:"text",id:"qnaContent",placeholder:"내용을 입력하세요"},domProps:{value:t.qnaContent},on:{input:function(e){e.target.composing||(t.qnaContent=e.target.value)}}})]),n("div",{staticClass:"text-right"},[n("button",{staticClass:"btn btn-primary",on:{click:t.checkHandler}},[t._v("등록")]),n("button",{staticClass:"btn btn-primary",on:{click:t.moveList}},[t._v("목록")])])])},O=[],T={name:"CreateQ",data:function(){return{qnaTitle:"",qnaContent:"",user:[]}},created:function(){this.user=JSON.parse(localStorage.getItem("userinfo")),this.user||(alert("접근 권한이 없습니다."),location.href="/")},methods:{checkHandler:function(){var t=!0,e="";!this.qnaTitle&&(e="제목 입력해주세요",t=!1,this.$refs.qnaTitle.focus()),t&&!this.qnaContent&&(e="내용 입력해주세요",t=!1,this.$refs.qnaContent.focus()),t?this.createHandler():alert(e)},createHandler:function(){var t=this;m.a.post("http://localhost:9999/board/qna",{qnaMemno:this.user.no,qnaTitle:this.qnaTitle,qnaContent:this.qnaContent}).then((function(e){var n=e.data,a="등록 처리시 문제가 발생했습니다.";"success"===n&&(a="등록이 완료되었습니다."),alert(a),t.moveList()}))},moveList:function(){this.$router.push("/list")}}},M=T,z=Object(i["a"])(M,$,O,!1,null,null,null),S=z.exports,D=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"qnaTitle"}},[t._v("제목")]),n("input",{directives:[{name:"model",rawName:"v-model",value:t.qnaTitle,expression:"qnaTitle"}],ref:"qnaTitle",staticClass:"form-control",attrs:{type:"text",id:"qnaTitle",placeholder:"제목을 입력하세요"},domProps:{value:t.qnaTitle},on:{input:function(e){e.target.composing||(t.qnaTitle=e.target.value)}}})]),n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"qnaContent"}},[t._v("내용")]),n("textarea",{directives:[{name:"model",rawName:"v-model",value:t.qnaContent,expression:"qnaContent"}],ref:"qnaContent",staticClass:"form-control",attrs:{type:"text",id:"qnaContent",placeholder:"내용을 입력하세요"},domProps:{value:t.qnaContent},on:{input:function(e){e.target.composing||(t.qnaContent=e.target.value)}}})]),n("div",{staticClass:"text-right"},[n("button",{staticClass:"btn btn-primary",on:{click:t.checkHandler}},[t._v("수정")])])])},H=[],A={name:"UpdateQ",data:function(){return{qnaNo:"",qnaMemno:"",qnaTitle:"",qnaContent:"",user:[]}},methods:{checkHandler:function(){var t=!0,e="";!this.qnaTitle&&(e="제목 입력해주세요",t=!1,this.$refs.qnaTitle.focus()),t&&!this.qnaContent&&(e="내용 입력해주세요",t=!1,this.$refs.qnaContent.focus()),t?this.updateHandler():alert(e)},updateHandler:function(){var t=this;m.a.put("http://localhost:9999/board/qna/updateQ/".concat(this.no),{qnaNo:this.qnaNo,qnaMemno:this.qnaMemno,qnaTitle:this.qnaTitle,qnaContent:this.qnaContent}).then((function(e){var n=e.data,a="수정 처리시 문제가 발생했습니다.";"success"===n&&(a="수정이 완료되었습니다."),alert(a),t.$router.push("/list")}))}},created:function(){var t=this;this.user=JSON.parse(localStorage.getItem("userinfo")),m.a.get("http://localhost:9999/board/qna/".concat(this.$route.query.no)).then((function(e){var n=e.data;t.qnaNo=n.qnaNo,t.qnaMemno=n.qnaMemno,t.qnaTitle=n.qnaTitle,t.qnaContent=n.qnaContent})),(!this.user||this.user.no!=this.qnaMemno&&1!=this.user.type)&&(alert("접근 권한이 없습니다."),location.href="/")}},P=A,Q=Object(i["a"])(P,D,H,!1,null,null,null),E=Q.exports,J=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[t._v(" 삭제중... ")])},I=[],Y={name:"DeleteQ",data:function(){return{memno:"",user:[]}},created:function(){var t=this;this.user=JSON.parse(localStorage.getItem("userinfo")),m.a.get("http://localhost:9999/board/news/".concat(this.$route.params.no)).then((function(e){var n=e.data;t.memno=n.qnaMemno,console.log(t.memno)})),!this.user||this.user.no!=this.memno&&1!=this.user.type?(alert("접근 권한이 없습니다."),location.href="/"):m.a.delete("http://localhost:9999/board/qna/".concat(this.$route.params.no)).then((function(e){var n=e.data,a="삭제 처리시 문제가 발생했습니다.";"success"===n&&(a="삭제가 완료되었습니다."),alert(a),t.$router.push("/list")}))}},L=Y,F=Object(i["a"])(L,J,I,!1,null,null,null),U=F.exports,R=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"replyContent"}},[t._v("내용")]),n("textarea",{directives:[{name:"model",rawName:"v-model",value:t.replyContent,expression:"replyContent"}],ref:"replyContent",staticClass:"form-control",attrs:{type:"text",id:"replyContent",placeholder:"내용을 입력하세요"},domProps:{value:t.replyContent},on:{input:function(e){e.target.composing||(t.replyContent=e.target.value)}}})]),n("div",{staticClass:"text-right"},[n("button",{staticClass:"btn btn-primary",on:{click:t.checkHandler}},[t._v("등록")])])])},B=[],G={name:"CreateA",data:function(){return{replyMemno:"13",replyContent:"",user:[]}},created:function(){this.user=JSON.parse(localStorage.getItem("userinfo")),this.user&&1==this.user.type||(alert("접근 권한이 없습니다."),location.href="/")},methods:{checkHandler:function(){var t=!0,e="";!this.replyContent&&(e="내용 입력해주세요",t=!1,this.$refs.replyContent.focus()),t?this.createHandler():alert(e)},createHandler:function(){var t=this;m.a.put("http://localhost:9999/board/qna/writeA/".concat(this.$route.query.no),{qnaNo:this.$route.query.no,replyMemno:this.replyMemno,replyContent:this.replyContent,reply:1}).then((function(e){var n=e.data,a="등록 처리시 문제가 발생했습니다.";"success"===n&&(a="등록이 완료되었습니다."),alert(a),t.moveList()}))},moveList:function(){this.$router.push("/list")}}},K=G,V=Object(i["a"])(K,R,B,!1,null,null,null),W=V.exports,X=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("div",{staticClass:"form-group"},[n("label",{attrs:{for:"replyContent"}},[t._v("내용")]),n("textarea",{directives:[{name:"model",rawName:"v-model",value:t.replyContent,expression:"replyContent"}],ref:"replyContent",staticClass:"form-control",attrs:{type:"text",id:"replyContent",placeholder:"내용을 입력하세요"},domProps:{value:t.replyContent},on:{input:function(e){e.target.composing||(t.replyContent=e.target.value)}}})]),n("div",{staticClass:"text-right"},[n("button",{staticClass:"btn btn-primary",on:{click:t.checkHandler}},[t._v("수정")])])])},Z=[],tt={name:"UpdateA",data:function(){return{qnaNo:"",replyContent:"",user:[]}},methods:{checkHandler:function(){var t=!0,e="";!this.replyContent&&(e="내용 입력해주세요",t=!1,this.$refs.replyContent.focus()),t?this.updateHandler():alert(e)},updateHandler:function(){var t=this;m.a.put("http://localhost:9999/board/qna/updateA/".concat(this.no),{qnaNo:this.qnaNo,replyMemno:this.user.no,replyContent:this.replyContent}).then((function(e){var n=e.data,a="수정 처리시 문제가 발생했습니다.";"success"===n&&(a="수정이 완료되었습니다."),alert(a),t.$router.push("/list")}))}},created:function(){var t=this;this.user=JSON.parse(localStorage.getItem("userinfo")),m.a.get("http://localhost:9999/board/qna/".concat(this.$route.query.no)).then((function(e){var n=e.data;t.qnaNo=n.qnaNo,t.replyContent=n.replyContent})),this.user&&1==this.user.type||(alert("접근 권한이 없습니다."),location.href="/")}},et=tt,nt=Object(i["a"])(et,X,Z,!1,null,null,null),at=nt.exports,st=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[t._v(" 삭제중... ")])},rt=[],ot={name:"DeleteA",data:function(){return{user:[]}},created:function(){var t=this;this.user=JSON.parse(localStorage.getItem("userinfo")),this.user&&1==this.user.type?m.a.put("http://localhost:9999/board/qna/deleteA/".concat(this.$route.params.no)).then((function(e){var n=e.data,a="삭제 처리시 문제가 발생했습니다.";"success"===n&&(a="삭제가 완료되었습니다."),alert(a),t.$router.push("/list")})):(alert("접근 권한이 없습니다."),location.href="/")}},lt=ot,it=Object(i["a"])(lt,st,rt,!1,null,null,null),ct=it.exports;a["a"].use(d["a"]);var ut=new d["a"]({made:"history",routes:[{path:"/",redirect:"/list"},{path:"/list",name:"list",component:g},{path:"/read",name:"read",component:N},{path:"/createQ",name:"createQ",component:S},{path:"/updateQ",name:"updateQ",component:E},{path:"/deleteQ/:no",name:"deleteQ",component:U},{path:"/createA",name:"createA",component:W},{path:"/updateA",name:"updateA",component:at},{path:"/deleteA/:no",name:"deleteA",component:ct}]}),dt=n("2f62");a["a"].use(dt["a"]);var ft=new dt["a"].Store({state:{},mutations:{},actions:{},modules:{}});a["a"].config.productionTip=!1,new a["a"]({router:ut,store:ft,render:function(t){return t(u)}}).$mount("#app")}});
//# sourceMappingURL=app.js.map