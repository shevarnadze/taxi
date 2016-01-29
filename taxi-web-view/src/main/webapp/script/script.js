//alert('Alert');
//vector = [1,2,3];
//var length = vector.length;
//vector.length = 2;
var vector = new Array(1,2,3,4,5,6,7,8,9,10);
var out = '';
//alert(out+"");
for(var i=0;i<vector.length;i++){
    //document.write('for')
    if(vector[i]%2==0){
        out = out + vector[i];
    }
}
document.write(out+"");

function fun(){
    var login = document.getElementById('login');
    var pass = document.getElementById('password');
    var el = document.getElementById('elh');
    el.innerHTML = 'OOOOOOOOOOOOOOOOOOOOOO' + login.value+pass.value;
    if(login.value===pass.value){
        //el.innerHTML = 'jjjj';
        var text = document.getElementById('text');
        text.value = 'ERROR';
    }
        //var el = document.getElementById('error');
        //el.innerHTML = 'error';
    //}
    //var el = document.getElementById('elh');
    //el.innerHTML = 'dsfsdfsdfdfsdfsdfsdfsdfs';
    //var text = document.getElementById('text');
    //text.value = '-----------';

    //alert(el.tagName);
}

//function ajax(){
//    var ajax = new XMLHttpRequest();
//    ajax.onreadystatechange = function(){
//        if(ajax.readyState==4 && ajax.status==200){
//            document.getElementById('elh').innerHTML = ajax.responseText;
//            alert(ajax.responseText)
//        }
//    }
//    ajax.open('POST', '/ajax', true);
//    ajax.send();
//}
//fun();
var  res = fun(1);
obj = {
    field: 3,
    metod: function(){

    }
};

obj.field = 4;
obj.metod();
obj.field2 = 4;

function Class(){

}

var obj2 = {};
obj2.field = 2222;

Class.prototype = obj2;
var newObj = new Class();
//Class.field = 2;
//new Class(); //конструкторная функция

//var newobj = Object.create(obj2);
//newObj.prototype = obj2;
document.write(newObj.field);