// Get params from url to read a list
const params = new URLSearchParams(window.location.search);
 

for(let param of params ){
    let id = param[1];
    // Send to getData function
    getData(id)
}

// Get data from URL
function getData(id){
  
  fetch('http://localhost:9092/list/read/'+id)
  .then(
    function(response) {
      if (response.status !== 200) {
        console.log('Error with code: ' +
          response.status);
        return;
      }

      response.json().then(function(data) {

        let div = document.querySelector("#readList");
        // Display data with the div it needs to be displayed in
        showData(div,data);

      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
  });
  // Listen for button 
  document
  .querySelector("#addToList")
  .addEventListener("click", function (stop) {
    stop.preventDefault();
   
    // Send to createItem with params
    window.location.replace("createItem.html?id="+id);

  });

}

function showData(div,data){
    // For each list
    for(let values in data){
      console.log(data)

      if(Array.isArray(data[values])==true && data[values]!=null){
          for(let items in data[values]){

              let newDiv = document.createElement("div");
              newDiv.setAttribute("class", "col-12");
              newDiv.setAttribute("id", "listDiv");
              let text = document.createTextNode(data[values][items].id + " - "+
              data[values][items].title  + " - "+
              data[values][items].message);

              // If marked as done, strikethrough
              if(data[values][items].done == true){
                newDiv.style.textDecoration='line-through';
              }
                
              let br = document.createElement("br");
              newDiv.appendChild(text);
              div.appendChild(newDiv);
              div.appendChild(br);
              // Add buttons to each item
              console.log("HI"+data[values][items]);
              createButtons(data[values][items], newDiv);
          }
      }
      else{

      }
           
    }
}

function createButtons(data, newDiv){
  
  // Done button
  doneButton = document.createElement("a");
  let doneButtonValue = document.createTextNode("Done")
  doneButton.className ="btn btn-success";
  doneButton.href="javascript:markAsDone("+data.id+")";
  doneButton.setAttribute("id", "listButton");
  doneButton.appendChild(doneButtonValue);
  newDiv.appendChild(doneButton);

  // Edit button
  let editButton = document.createElement("a");
  let editButtonValue = document.createTextNode("Edit Item")
  editButton.className ="btn btn-secondary";
  editButton.setAttribute("id", "listButton");
  editButton.href="editItem.html?id="+data.id;
  editButton.appendChild(editButtonValue);
  newDiv.appendChild(editButton);

  // Delete button
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

// Function to mark item as done in the system
function markAsDone(id){

 fetch('http://localhost:9092/item/read/'+id)
 .then(
   function(response) {
     if (response.status !== 200) {
       console.log('Error,status Code: ' + response.status);
       return;
     }
     response.json().then(function(data) {
      if(data.done==false){
        data.done = true;
      }
      else{
        data.done = false;
      }

      fetch("http://localhost:9092/item/update/"+id, {
        method: 'put',
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        },
        body:JSON.stringify(data)
      })
      .then(function (data) {
        console.log('Success! Response: ', data);
        window.location.reload();
      })
      .catch(function (error) {
        console.log('Failed! Response: ', error);
      });
 
     });
   }
 )
 .catch(function(err) {
   console.log('Fetch Error :-S', err);
 });

}

// Delete function
function deleteByid(id){
  fetch("http://localhost:9092/item/delete/"+id, {
      method: 'delete',
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      },
})}