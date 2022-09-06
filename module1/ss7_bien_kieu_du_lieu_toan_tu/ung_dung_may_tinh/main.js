function tinhtoan(value) {
    let a=document.getElementById("nhapso").value;
    let b=document.getElementById("nhapso2").value;
    a=parseInt(a);
    b=parseInt(b);
    if(value=='c'){
        alert(a+b);
    }
    if(value=='d'){
        alert(a-b);
    }
    if(value=='e'){
        alert(a*b);
    }
    if(value=='f'){
        alert(a/b);
    }
}