const params = new URLSearchParams(window.location.search);
 

for(let param of params ){
    let id = param[1];
    console.log(id);
    getData(id)
}


function getData(id){
  
  fetch('http://localhost:9092/list/read/'+id)
  .then(
    function(response) {
      if (response.status !== 200) {
        console.log('Looks like there was a problem. Status Code: ' +
          response.status);
        return;
      }

      // Examine the text in the response
      response.json().then(function(data) {
       

        let div = document.querySelector("#readList");
       // let dataKeys = Object.keys(data[0]);
        
        //createTitles(div,data);
        showData(div,data);
        
      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
  });
  document
  .querySelector("#addToList")
  .addEventListener("click", function (stop) {
    stop.preventDefault();
    //let formElements = document.querySelector("form.viewRecord").elements;
    window.location.replace("createItem.html?id="+id);
    // postData(noteTitle,noteBody)
  });

}

  function showData(div,data){
    console.log(data)
    //for(let record of data){
    
      
       // let newDiv = table.insertRow();
        
        for(let values in data){
         console.log(data)
          //let text = document.createTextNode(record[values]);
          //newDiv.appendChild(text);
          //div.appendChild(newDiv)
            //let cell = row.insertCell(); console.log(record[values])
             if(Array.isArray(data[values])==true && data[values]!=null){
               for(let items in data[values]){
                let newDiv = document.createElement("div");
                newDiv.setAttribute("class", "col-12");
                newDiv.setAttribute("id", "listDiv");
                 let text = document.createTextNode(data[values][items].id + " - "+
                 data[values][items].title  + " - "+
                 data[values][items].message);
                 // newDiv.appendChild(text);
                  //div.appendChild(newDiv)

                  if(data[values][items].done == true){
                    newDiv.style.textDecoration='line-through';
                  }
                  

                  let br = document.createElement("br");
                  newDiv.appendChild(text);
                  div.appendChild(newDiv);
                  div.appendChild(br);
                  createButtons(data[values][items], newDiv);
               }
             }
             else{
                // let text = document.createTextNode(record[values]);
                // newDiv.appendChild(text);
             }
           
        }
    

   // }
}

function createButtons(data, newDiv){
  
  doneButton = document.createElement("a");
  let doneButtonValue = document.createTextNode("Done")
  doneButton.className ="btn btn-success";
  doneButton.href="javascript:markAsDone("+data.id+")";
  doneButton.setAttribute("id", "listButton");
  doneButton.appendChild(doneButtonValue);
  newDiv.appendChild(doneButton);

  // document
  // .querySelector("#doneButton")
  // .addEventListener("click", function (stop) {
  //   stop.preventDefault();
  //   //let formElements = document.querySelector("form.viewRecord").elements;
  //   markAsDone(data.id);
  //   // postData(noteTitle,noteBody)
  // });
  let editButton = document.createElement("a");
  let editButtonValue = document.createTextNode("Edit Item")
  editButton.className ="btn btn-secondary";
  editButton.setAttribute("id", "listButton");
  editButton.href="editItem.html?id="+data.id;
  editButton.appendChild(editButtonValue);
  newDiv.appendChild(editButton);



let deleteButton = document.createElement("button");
let deleteButtonValue = document.createTextNode("Delete item")
deleteButton.className ="btn btn-danger";
deleteButton.setAttribute("id", "listButton");
deleteButton.onclick = function(){
  deleteByid(data.id);
  alert("Deleted item "+data.id);
  window.location.reload;
  return false;
};
deleteButton.appendChild(deleteButtonValue);
newDiv.appendChild(deleteButton)
}

function markAsDone(id){

 //newDiv.style.textDecoration='line-through';

 fetch('http://localhost:9092/item/read/'+id)
 .then(
   function(response) {
     if (response.status !== 200) {
       console.log('Looks like there was a problem. Status Code: ' +
         response.status);
       return;
     }

     // Examine the text in the response
     response.json().then(function(data) {
      if(data.done==false){
        data.done = true;
      }
      else{
        data.done = false;
      }
      
     // console.log("Data to post",data)
      
      
      fetch("http://localhost:9092/item/update/"+id, {
        method: 'put',
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        },
        body:JSON.stringify(data)
      })
      .then(function (data) {
        console.log('Request succeeded with JSON response', data);
        window.location.reload();
      })
      .catch(function (error) {
        console.log('Request failed', error);
      });
      // let dataKeys = Object.keys(data[0]);
       
       //createTitles(div,data);
       
     });
   }
 )
 .catch(function(err) {
   console.log('Fetch Error :-S', err);
 });

}
function deleteByid(id){
  fetch("http://localhost:9092/item/delete/"+id, {
      method: 'delete',
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      },
    })}
// function createTitles(div,data){
//     let h1 = document.createElement("h1");
//     for(let keys of data){
        
//         // console.log("data",data)
     
//         let text = document.createTextNode("  "+keys);
//         h1.appendChild(text);
//         div.appendChild(h1)
        
//     }


//     //let h2 = document.createElement("h1")
//     let text2 = document.createTextNode("   View");
//     h1.appendChild(text2);
//     div.appendChild(h1);
//    // let h1 = document.createElement("h1")
//     let text3 = document.createTextNode("   Edit");
//     h1.appendChild(text3);
//     div.appendChild(h1)
//     //let h4 = document.createElement("h1")
//     let text4 = document.createTextNode("   Delete");
//     h1.appendChild(text4);
//     div.appendChild(h1);
// }