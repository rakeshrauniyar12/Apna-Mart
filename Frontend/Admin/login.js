document.querySelector("#submit").addEventListener("click",()=>{
    addUser();
  })
  let addUser= async ()=>{
    //     "adminName":"abhi",
    //    "adminEmail":"abh@gmail.com",
    //    "adminPassword":"abhi@12345",
    //    "mobileNo":"9884848487",
    //    "address":{
    //        "city":"Ramkola",
    //        "state":"Uttar-Pradesh",
    //        "pincode":"353533",
    //        "country":"India"
    //    }
        let adminEmail=document.querySelector("#email").value;
        let adminPassword=document.querySelector("#password").value;
        let res = await fetch(`http://localhost:8090/admin/loginadmin/${adminEmail}`)
        res = await res.json();
       console.log(res);
      
        document.querySelector("#email").value="";
        document.querySelector("#password").value="";
        
       
        // getData();
    }