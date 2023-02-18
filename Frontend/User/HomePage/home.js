let images=["https://www.lavamobiles.com/product/blaze/images/banner.jpg",
"https://i.pinimg.com/736x/ee/26/80/ee2680013379bc37742f99ed6fee72ea.jpg",
"https://tse3.mm.bing.net/th?id=OIP.b1oqWj4cWROHK49DX_NfLgHaEK&pid=Api&P=0",
"https://images.samsung.com/is/image/samsung/ae_UA46EH6030RXZN_005_Front_black?$L2-Thumbnail$"];

let i=0;
let cont1= document.querySelector("#image");
setInterval(()=>{
    cont1.innerHTML="";
   let img= document.createElement("img");
   img.src=images[i];
    cont1.append(img)
    i++;
    if(i===images.length){
        i=0;
    }
},3000);
let tt22=document.querySelector("#t2").innerText;
console.log(tt22);
async function viewProducts() {
    let res = await fetch("https://sweltering-ladybug-production.up.railway.app/getallproduct");
    res = await res.json();
    renderDom(res);
  }
  viewProducts();
  let renderDom = (data) => {
    let cont = document.querySelector("#cont");
    cont.innerHTML = "";
    data.forEach((el) => {
      let div = document.createElement("div");
     // div.style = "display:flex;";
      let img = document.createElement("img");
      img.src = el.imageUrl;
      let h2 = document.createElement("p");
      h2.innerText = el.name;
      let p2 = document.createElement("p");
      p2.innerText = el.price;
      let p3 = document.createElement("p");
      p3.innerText = "Stock";
      let btn1= document.createElement("button");
      btn1.innerText="Add to Cart";
      btn1.addEventListener("click",()=>{
        saveProductToCart(el);
      })
      div.append( img, h2, p2, p3,btn1);
      cont.append(div);
    });
  };
  async function saveProductToCart(el){
       let id= JSON.parse(localStorage.getItem("user_id"));
           let res= await fetch(`https://sweltering-ladybug-production.up.railway.app/${id}`,{
            method: "POST",
        body: JSON.stringify(el),
       headers: {
      "Content-Type": "application/json",
          },
  });
  res = await res.json();

console.log(res);
  }