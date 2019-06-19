var app =  {
    $wrapper :  $wrapper = document.querySelector('#wrapper'),
    init : init
};
     var customers ={
        mypage : mypage,
        mypage_form : mypage_form,
        login_form : login_form,
        join_form : join_form,
        login : login,
        join : join,
        count : count,
        update : update,
        update_form : update_form,
        remove : remove
     };
     var employee = {
         login : login,
         customers_list : customers_list,
         admin_login : admin_login
     };

     var session = {
          set_value : set_value,
          get_value : get_value
     };

     function set_value(x) {
         sessionStorage.setItem(x.name,x.value);
     }
     function get_value(x) {

         return sessionStorage.getItem(x);
     }
    function  init() {
        $wrapper.innerHTML = customers.login_form();
        //let login_btn = document.querySelector('#login-btn');
        
        
        document.getElementById('login-btn')
        .addEventListener('click',e=>{
            e.preventDefault();
            customers.login({userid:'customerId',
                            domain: 'customers'});
        }); 

        document.getElementById('admin-btn')
        .addEventListener('click',e=>{
            e.preventDefault();
            alert('admin 클릭');
            
            employee.admin_login();
        });
        ///let join_btn = document.querySelector('#join-btn');
        document.getElementById('join-btn')
        .addEventListener('click',()=>{
            $wrapper.innerHTML = customers.join_form();
            document.getElementById('confirm-btn')
            .addEventListener('click', e=>{
                e.preventDefault();
                alert('조인버튼 클릭');
                customers.join();
            });
        });
    };
    function join(){
        let xhr = new XMLHttpRequest();
        let data = {
                    customerId : document.getElementById('customerId').value,
                    customerName : document.getElementById('customerName').value,
                    password : document.getElementById('password').value,
                    ssn : document.getElementById('ssn').value,
                    phone : document.getElementById('phone').value,
                    city : document.getElementById('city').value,
                    address : document.getElementById('address').value,
                    postalcode : document.getElementById('postalcode').value

        };
        xhr.open('POST','customers',true);
        xhr.setRequestHeader('Content-type','application/json; charset= utf-8')
        xhr.onload=()=>{
            if (xhr.readyState==4 & xhr.status == 200) {
                let d = JSON.parse(xhr.responseText);   //  java hashmap => json으로 변환 
                if (d.result === 'SUCCESS') {
                    alert(''+d.result);
                    app.init();
                } else {
                    alert(' join fail');
                }
                alert('join success'+d.result);//login form 
            }else {
                alert(' ajax fail');
            }
        };
        xhr.send(JSON.stringify(data));//json => string  변환  controller로 보낼때  javascript =>  java
    };

    function login(x) {
        alert(x.userid);
        id = document.getElementById(x.userid).value;
        pass = document.getElementById('password').value;
        let xhr = new XMLHttpRequest();
        xhr.open('GET', x.domain+'/'+id+'/'+pass, true);
        xhr.onload=()=> {
          if (xhr.readyState==4 && xhr.status == 200) {
              let d = JSON.parse(xhr.responseText);   //  java dto => json으로 변환 
              session.set_value({'name':'userid','value':d.customerId}); 
              session.set_value({'name':'username','value':d.customerName}); 
              
              alert('로그인 성공후 이름:'+d.customerName)
              
               //$wrapper.innerHTML = customers.mypage(d);
               if (d) {
                   if (x.domain==='customers') {
                    session.set_value({'name':'user', 'value':d});  
                    customers.mypage(d);
                   } else {
                       employee.customers_list();
                   }
               } else {
                   app.init();
               }
           
              }
        };
        xhr.send();
}

    function admin_login() {
        let isAdmin = confirm("관리자입니까?");
        if (isAdmin) {
            let pass = prompt("관리자 번호를 입력하세요");
            if (pass == 1000) {
                employee.customers_list();
            }else{
                alert('입력한 번호가 일치하지 않습니다.');
            }
        } else {
            alert('관리자만 접속이 가능합니다.');
        }
    }
    function customers_list() {
       
        let xhr = new XMLHttpRequest();
        xhr.open('GET','customers',true);
        xhr.onload=()=>{
            if(xhr.readyState===4 && xhr.status === 200){
               let d = JSON.parse(xhr.responseText);
                     
            

               }
             
               
            };
            xhr.send();
        }
       
    
    function count(){
        var xhr = new XMLHttpRequest();
        xhr.open('GET', 'count', true);
        xhr.onload=()=>{
            if(xhr.readyState===4 && xhr.status === 200){
                alert('성공');
                let wrapper = document.querySelector('#wrapper');
                wrapper.innerHTML = '총 고객수 : <h1>'+xhr.responseText+'</h1>'
            }
        }
        xhr.send();
    };

function update(x) {
    let wrapper = document.querySelector('#wrapper');
    wrapper.innerHTML = customers.update_form(x);
    alert('수정할 아이디: '+ document.getElementById('customerId').innerText );
    document.getElementById('confirm-btn')
    .addEventListener('click', e=> {
             e.preventDefault();
             let data = {
                customerId : document.getElementById('customerId').innerText,
                customerName : document.getElementById('customerName').innerText,
                password : document.getElementById('password').value,
                ssn : document.getElementById('ssn').innerText,
                phone : document.getElementById('phone').value,
                city : document.getElementById('city').value,
                address : document.getElementById('address').value,
                postalcode : document.getElementById('postalcode').value

                }
            let xhr = new XMLHttpRequest();
            xhr.open('PUT','customers/'+x.customerId, true);
            xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
            xhr.onload=()=>{
                if (xhr.readyState===4 && xhr.status === 200) {
                    let d = JSON.parse(xhr.responseText);
                    customers.mypage(d);
                }
            };
            xhr.send(JSON.stringify(data));
            });
        }

   
function remove() {
    let customerId = document.getElementById('customerId');
    let xhr = new XMLHttpRequest();
    xhr.open('DELETE','customers/'+customerId,true);
    xhr.onload=()=>{
        if(xhr.readyState===4 && xhr.status === 200){
            alert('성공');
            let wrapper = document.querySelector('#wrapper');
            wrapper.innerHTML = '총 고객수 : <h1>'+xhr.responseText+'</h1>'
        }
    };
    xhr.send();
}

function mypage(x){
    $wrapper.innerHTML = customers.mypage_form(x);
  
    
    document.getElementById('update-btn')
    .addEventListener('click', e=>{
        e.preventDefault();
        alert('세션테스트 id'+ session.get_value('userid'));
        alert('세션테스트 name'+ session.get_value('username'));
        customers.update(x);
    });
    alert(document.getElementById('remove-btn'))
    document.getElementById('remove-btn')
    .addEventListener('click', e=>{
        e.preventDefault();
        alert('탈퇴버튼 클릭'+x.customerId);
        let xhr = new XMLHttpRequest();
        xhr.open('DELETE', 'customers/'+x.customerId, true);
        xhr.onload=()=>{
            if (xhr.readyState=== 4 && xhr.status === 200) {
                app.init();
            }
        };
        xhr.send();
    });
    return '<h1>마이페이지</h1> ';
}

function join_form(){
return '<form>'
+'  아이디<br>'
+'	<input type="text" id="customerId" name="customerId"><br>'
+'	비밀번호<br>'
+'	<input type="password" id = "password" name="password"><br>'
+'	이름<br>'
+'	<input type="text"id = "customerName" name="customerName"><br>'
+'	<br><br>'
+'	주민번호<br>'
+'	<input type="text"id = "ssn" name="ssn"><br>'
+'	<br><br>'
+'	전화번호<br>'
+'	<input type="text"id = "phone" name="phone"><br>'
+'	<br><br>'
+'	도시<br>'
+'	<input type="text"id = "city" name="city"><br>'
+'	<br><br>'
+'	주소<br>'
+'	<input type="text"id = "address" name="address"><br>'
+'	<br><br>'
+'	우편번호<br>'
+'	<input type="text"id = "postalcode" name="postalcode"><br>'
+'	<br><br>'
+'	<input id="confirm-btn" type="submit" value="확인">'
+'	<input id="cancel-btn" type="reset" value="취소">'
+'</form>';
};
function update_form(x){
    return '<form>'
    +'  아이디<br>'
    +'	<span id = "customerId">'+x.customerId+'</span><br>'
    +'	비밀번호<br>'
    +'	<input type="password" id = "password" name="password" value="'+x.password+'"><br>'
    +'	이름<br>'
    +'	<span id = "customerName">'+x.customerName+'</span><br>'
    +'	<br><br>'
    +'	주민번호<br>'
    +'	<span id = "ssn">'+x.ssn+'</span><br>'
    +'	<br><br>'
    +'	전화번호<br>'
    +'	<input type="text"id = "phone" name="phone"><br>'
    +'	<br><br>'
    +'	도시<br>'
    +'	<input type="text"id = "city" name="city"><br>'
    +'	<br><br>'
    +'	주소<br>'
    +'	<input type="text"id = "address" name="address"><br>'
    +'	<br><br>'
    +'	우편번호<br>'
    +'	<input type="text"id = "postalcode" name="postalcode"><br>'
    +'	<br><br>'
    +'	<input id="confirm-btn" type="submit" value="수 정">'
    +'	<input id="cancel-btn" type="reset" value="탈퇴">'
    +'</form>';
    };

function mypage_form(x){
    let customers = x;
    return '<h1>'+customers.customerName+'마이페이지</h1><br>'
    +'  아이디<br>'
    +'	<span id="customerId">'+customers.customerId+'</span><br>'
    +'	비밀번호<br>'
    +'	<span id="password">'+customers.password+'</span><br>'
    +'	이름<br>'
    +'	<span id="customerName">'+customers.customerName+'</span><br>'
    +'	<br><br>'
    +'	주민번호<br>'
    +'	<span id="ssn">'+customers.ssn+'</span><br>'
    +'	<br><br>'
    +'	전화번호<br>'
    +'	<span id="phone">'+customers.phone+'</span><br>'
    +'	<br><br>'
    +'	도시<br>'
    +'	<span id="city">'+customers.city+'</span><br>'
    +'	<br><br>'
    +'	주소<br>'
    +'	<span id="address">'+customers.address+'</span><br>'
    +'	<br><br>'
    +'	우편번호<br>'
    +'	<span id="postalcode">'+customers.postalcode+'</span><br>'
    +'	<br><br>'
    +'	<input id="update-btn" type="submit" value="수 정">'
    +'	<input id="remove-btn" type="reset" value="탈퇴">'
    };

function login_form(){
    return '<form action="/action_page.php">'
        +'  First name:<br>'
        +'  <input type="text" id="customerId" name="customerId">'
        +'  <br>'
        +'  Last name:<br>'
        +'  <input type="text" id="password" name="password">'
        +'  <br><br>'
        +'  <input id="login-btn" type="button" value="LOGIN">'
        +'  <input id="join-btn" type="button" value="JOIN">'
        +'  <input id="admin-btn" type="button" value="관리자">'
        +'  </form> ';

    }
