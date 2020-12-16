// Get params from url to read a list
const params = new URLSearchParams(window.location.search);
 
for(let param of params ){
    let id = param[1];
    // Send to get data
    getData(id)
}


function getData(id){
  
  fetch('http://localhost:9092/item/read/'+id)
  .then(
    function(response) {
      if (response.status !== 200) {
        console.log('Error with Code: ' + response.status);
        return;
      }

      response.json().then(function(data) {
        showData(data);
      });
    }
  )
  .catch(function(err) {
    console.log('Fetch Error :-S', err);
  });
}

// Show data in form
function showData(data){
  document.querySelector("input#idInput").value = data.id;
  document.querySelector("input#nameInput").value = data.title;
  document.querySelector("textarea#messageInput").value = data.message;
}


// Listen for submit button
document
.querySelector("form.viewRecord")
.addEventListener("submit", function (stop) {
  stop.preventDefault();
  let formElements = document.querySelector("form.viewRecord").elements;

  // Add values from form
  let id =formElements["idInput"].value;
  let name=formElements["nameInput"].value;
  let message=formElements["messageInput"].value;
  let data = {
    "id": id,
    "done": false,
    "title":name,
    "message":message
  }

  // Send to db
  sendData(data)
  // Go to read List page
  //window.location.replace("readList.html?id="+data.id);
  window.history.back();
});

// Put data to url
function sendData(data){
    fetch("http://localhost:9092/item/update/"+data.id, {
        method: 'put',
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        },
        body:JSON.stringify(data)
      })
      .then(function (data) {
        console.log('Success! Response: ', data);
      })
      .catch(function (error) {
        console.log('Failed! REsponse: ', error);
      });
}
