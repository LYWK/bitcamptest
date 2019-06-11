alert('자바스크립트 연결 성공 !!');

var wrapper = document.querySelector('#wrapper');
wrapper.innerHTML = '<h1>spa  시작</h1> '
                   +'<div id = "target">삭제할 내용 </div>'
                   +'<button id = "btn">지워버리자</button>'
                   +'<button id = "btn2">추가해버리자</button>';
var btn = document.querySelector('#btn');  //객체 생성 
var target = document.getElementsById("target");
btn.addEventListener('click',function(){
    // wrapper.innerHTML = '<h1>spa  시작</h1> '+'<div>       </div>'+ '<button id = "btn">지워버리자</button>';
 //   document.getElementById('delete').innerHTML = '';
   target.innerHTML = '';

});

var btn2 = document.querySelector('#btn2');

btn2.addEventListener('click',function(){
     var temp = document.createTextNode('새추가');
      target.appendChild(temp);
});