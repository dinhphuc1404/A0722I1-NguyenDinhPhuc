﻿function Fly(a,b,c,d,e,f,g,h,i){function q(){o<0?n<0?(k=100,l=150):(k=0,l=50):n<0?(k=300,l=350):(k=200,l=250)}function r(a){j.style.backgroundPosition="0px -"+a+"px"}if(void 0===h||""==h)var h="image/flies.png";if(void 0===d||0==d||void 0===e||0==e)if("number"==typeof window.innerWidth)var e=window.innerWidth,d=window.innerHeight;else if(document.documentElement&&(document.documentElement.clientWidth||document.documentElement.clientHeight))var e=document.documentElement.clientWidth,d=document.documentElement.clientHeight;else if(document.body&&(document.body.clientWidth||document.body.clientHeight))var e=document.body.clientWidth,d=document.body.clientHeight;var j=document.createElement("DIV"),k=200,l=250,m=!0;if(void 0===f||0==f||void 0===g||0==g){var f=0,g=0;if(Math.random()<.5){if(Math.random()<.5)var f=5;else var f=e-50;var g=Math.round(Math.random()*(d-50))}else{if(Math.random()<.5)var g=5;else var g=d-50;var f=Math.round(Math.random()*(e-50))}}if(void 0===n||0==n)var n=3;if(void 0===o||0==o)var o=3;this.movestep=30,this.type=b,this.name=i,this.color=c,this.fid=a,this.move_strange=!1,Math.random()<.5?this.gender="Ã„ÂÃ¡Â»Â±c":this.gender="CÄ‚Â¡i",j.title=this.name+"\nLoÃ¡ÂºÂ¡i: "+this.type+"\nMÄ‚ u sÃ¡ÂºÂ¯c: "+this.color+"\nGiÃ¡Â»â€ºi tÄ‚Â­nh: "+this.gender,j.id=a,j.style.width="50px",j.style.height="50px",j.style.backgroundImage="url("+h+")",j.style.backgroundPosition="0px -"+k+"px",j.style.position="absolute",j.style.left=Math.round(f)+"px",j.style.top=Math.round(g)+"px",j.style.zIndex=9999,j.style.cursor="pointer",j.style.cursor="url('/images/xit_muoi.png'), auto;";var p=this;j.addEventListener("click",function(){p.flying()},!1),document.body.appendChild(j),this.setmove=function(a){var b=this;b.move_strange||(g>=d-50||Math.random()<.005?(o=-o,q()):(g<=1||Math.random()<.005)&&(o=-o,q()),f>=e-50||Math.random()<.005?(n=-n,q()):(f<=1||Math.random()<.005)&&(n=-n,q())),f+=n,g+=o,j.style.left=Math.round(f)+"px",j.style.top=Math.round(g)+"px",Math.random()<.05?(clearInterval(a),a=setInterval(function(){b.p(a)},this.movestep),m=!1,r(k)):m?(m=!1,r(k)):(m=!0,r(l))},this.p=function(a,b){var c=this;Math.random()<.075&&(clearInterval(a),a=setInterval(function(){c.setmove(a)},c.movestep))},this.move=function(){var a=this,b=setInterval(function(){a.setmove(b)},a.movestep)},this.flying=function(){this.movestep=0;var a=this;timeout=2500*Math.random()+2500,setTimeout(function(){a.movestep=30},timeout)},this.moveout=function(){var a=this,b=0,c=0;if("number"==typeof window.innerWidth)var b=window.innerWidth,c=window.innerHeight;else if(document.documentElement&&(document.documentElement.clientWidth||document.documentElement.clientHeight))var b=document.documentElement.clientWidth,c=document.documentElement.clientHeight;else if(document.body&&(document.body.clientWidth||document.body.clientHeight))var b=document.body.clientWidth,c=document.body.clientHeight;a.move_strange=!0;var d=setInterval(function(){(g>=c-50||f>=b-50||g<=0||f<=0)&&($("#"+a.fid).hide(),a.move_strange=!1,clearInterval(d))},30)},this.goback=function(){var a=this,b=0,c=0;if("number"==typeof window.innerWidth)var b=window.innerWidth,c=window.innerHeight;else if(document.documentElement&&(document.documentElement.clientWidth||document.documentElement.clientHeight))var b=document.documentElement.clientWidth,c=document.documentElement.clientHeight;else if(document.body&&(document.body.clientWidth||document.body.clientHeight))var b=document.body.clientWidth,c=document.body.clientHeight;a.move_strange=!0;var d=setInterval(function(){(g>=c-50||f>=b-50||g<=0||f<=0)&&($("#"+a.fid).show(),a.move_strange=!1,clearInterval(d))},30)}}$(document).ready(function(){var a=$("script[src*=flies-obj]"),b=a.attr("var_1"),c=a.attr("var_2");if("true"==a.attr("var_3"))var e=170,f=1e3;else var e=0,f=0;if("false"==b)return!1;switch(Math.floor(4*Math.random())+1){case 1:var h=new Fly("test","NhÃ¡ÂºÂ·ng","Ã„Âen",e,f,0,0,"https://1.bp.blogspot.com/-gw4ADu38VZI/VtDSJWxpBVI/AAAAAAAAClo/LfFRNfLD6YQ/s1600/flies.png","Long ruÃ¡Â»â€œi");break;case 2:var h=new Fly("test","NhÃ¡ÂºÂ·ng","Xanh",e,f,0,0,"https://2.bp.blogspot.com/-RJWSmB7LWCs/VtDQbezMLkI/AAAAAAAAClc/4BMD7iBSQzw/s1600/style_1.png","King ruÃ¡Â»â€œi");break;case 3:var h=new Fly("test","NhÃ¡ÂºÂ·ng","TuyÃ¡Â»â€¡t sÃ¡ÂºÂ¯c",e,f,0,0,"https://1.bp.blogspot.com/-O6lAftMxB50/VtDQbAdt1hI/AAAAAAAAClY/v-9OEzMS1VQ/s1600/style_2.png","Tom ruÃ¡Â»â€œi");break;case 4:var h=new Fly("test","NhÃ¡ÂºÂ·ng","HÃ¡Â»â€œng",e,f,0,0,"https://1.bp.blogspot.com/-Q7Lzc5UOMJg/VtDQbJjA-KI/AAAAAAAAClU/11UJMD7hf4k/s1600/style_3.png","Queen ruÃ¡Â»â€œi")}if(h.move(),"true"==c){var i=new Fly("test","NhÃ¡ÂºÂ·ng","Xanh",e,f,0,0,"https://2.bp.blogspot.com/-RJWSmB7LWCs/VtDQbezMLkI/AAAAAAAAClc/4BMD7iBSQzw/s1600/style_1.png","King ruÃ¡Â»â€œi");i.move(),i.flying()}$("#btnMove").click(function(){h.move(),i.move(),fly3.move()}),$("#btnFlying").click(function(){h.flying()}),$("#btnHide").click(function(){h.moveout()}),$("#btnShow").click(function(){h.goback()})});
