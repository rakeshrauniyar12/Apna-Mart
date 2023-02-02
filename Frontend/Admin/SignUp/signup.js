
  document.querySelector("#submit").addEventListener("click",()=>{
    registerAdmin();
  })
let registerAdmin= async ()=>{
    let adminName=document.querySelector("#name").value;
    let adminEmail=document.querySelector("#email").value;
    let adminPassword=document.querySelector("#password").value;
    let mobileNo=document.querySelector("#mobile").value;
    let city=document.querySelector("#city").value;
    let state=document.querySelector("#state").value;
    let pincode=document.querySelector("#pincode").value;
    let country=document.querySelector("#country").value;
    let userData={
        adminName,adminEmail,adminPassword,mobileNo,address:{
            city,state,pincode,country
        }
    };
  console.log(userData)
    let res = await fetch("http://localhost:8090/admin/saveadmin",{
        method:"POST",
        body:JSON.stringify(userData),
        headers:{
            "Content-Type":"application/json"
        }
    })
    res = await res.json();
    let img=document.createElement("img");
     img.src=res.adminName;
    document.querySelector("#image").append(img);
    console.log(res);
    document.querySelector("#name").value="";
    document.querySelector("#email").value="";
    document.querySelector("#password").value="";
    document.querySelector("#mobile").value="";
    document.querySelector("#city").value="";
    document.querySelector("#state").value="";
    document.querySelector("#country").value="";
    document.querySelector("#pincode").value="";
}