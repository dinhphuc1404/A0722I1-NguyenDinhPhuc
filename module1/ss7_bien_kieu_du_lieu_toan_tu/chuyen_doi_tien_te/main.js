function a(){
    let nhap=document.getElementById("o1").value;
    let from=document.getElementById("from").value;
    let to=document.getElementById("to").value;
    if (from==to){
        document.getElementById("ketqua").innerHTML = nhap;
    }else if (from =='vnd' && to=='usd'){
        document.getElementById("ketqua").innerHTML = nhap/23000;
    }else if (from =='usd' && to=='vnd'){
        document.getElementById("ketqua").innerHTML = nhap*23000;
    }
}