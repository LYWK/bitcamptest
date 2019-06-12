

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
      +'  <input id="login-btn" type = "button" value="Login">'
      +'  <input id="join-btn"  type = "button" value="Join">'
      +'</form> ';
        let join_btn = document.querySelector('#join-btn');
        join_btn.addEventListener('click',function(){
              Join_form();
        });
        
    //   var Join = document.querySelector('#Join');
    //   wrapper.innerHTML = '<form>'
    //   +'   ID:<br>'
    //   +'  <input type="text" name="id">'
    //   +'  <br>'
    //   +'   Pass:<br>'
    //   +'  <input type="text" name="pass">'
    //   +'   Name:<br>'
    //   +'  <input type="text" name="Name">'
    //   +'   Ssn:<br>'
    //   +'  <input type="text" name="Ssn">'
    //   +'   Phone:<br>'
    //   +'  <input type="text" name="Phone">'
    //   +'</form>';
     }

     let Join_form = function(){
            let wrapper = document.querySelector('#wrapper');
            wrapper.innerHTML = '<form>'
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
    return {init : init};// closure  -app에 init로 property 등록 
})();


   
