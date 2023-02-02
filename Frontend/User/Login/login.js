document.querySelector("#submit").addEventListener("click",()=>{
    loginUser();
  })
  let loginUser= async ()=>{
        let userEmail=document.querySelector("#email").value;
        let adminPassword=document.querySelector("#password").value;
        let res = await fetch(`http://localhost:8090/loginuser/${userEmail}`)
        res = await res.json();
        console.log(res);
        document.querySelector("#email").value="";
        document.querySelector("#password").value="";
    }
    // =============================================
//     document.querySelector("#login1").addEventListener("click",()=>{
//       login();
//   })
//  let url = "https://masai-api-mocker.herokuapp.com/auth/login"
//  let login = async ()=>{
//   let data = {
//           username:document.querySelector("#user").value,
//           password:document.querySelector("#password").value,
//   }
//   let res = await fetch(url,{
//       method:"POST",
//       body:JSON.stringify(data),
//       headers:{
//           "Content-Type":"application/json",
//       }
//   })
//   res= await res.json();
//   console.log(res);
//   getProfile(res.token,data.username,res.error);
 
//  }
//  let getProfile= async(token,user,error)=>{
//   let res = await fetch(`https://masai-api-mocker.herokuapp.com/user/${user}`,{
//       headers:{
//           Authorization:`Bearer ${token}`,
//       }
//   })
//   res=await res.json();
//   if(error===false){
//       localStorage.setItem("userData",JSON.stringify(res));
//       window.location.href="../homepage/h.html";
//       document.querySelector("#user").value="";
//   document.querySelector("#password").value="";
//   } else {
//       alert("Credential Does Not match");
//   }
 
//  }