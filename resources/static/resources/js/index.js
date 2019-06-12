

var app = (function(){//app 에서  init 를 알수 없다. 
    let init= function(){
      login_form();

    }
    let login_form = function(){
      var wrapper = document.querySelector('#wrapper');
      wrapper.innerHTML = '<form action="/action_page.php">'
      +'  First name:<br>'
      +'  <input type="text" name="firstname" value="Mickey">'
      +'  <br>'
      +'  Last name:<br>'
      +'  <input type="text" name="lastname" value="Mouse">'
      +'  <br><br>'
      +'  <input type="submit" value="Submit">'
      +'</form> ';
      var btn = document.querySelector('#btn');  //객체 생성 
      var target = document.getElementById("target");
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

      var Join = document.querySelector('#Join');
      Join.innerHTML = '<form>'
      +'   ID:<br>'
      +'  <input type="text" name="id">'
      +'  <br>'
      +'   Pass:<br>'
      +'  <input type="text" name="pass">'
      +'   Name:<br>'
      +'  <input type="text" name="Name">'
      +'   Ssn:<br>'
      +'  <input type="text" name="Ssn">'
      +'   Phone:<br>'
      +'  <input type="text" name="Phone">'
      +'</form>';
    }

    let Join_form = function(){

    }
    return {init : init};// closure  -app에 init로 property 등록 
})();

   
