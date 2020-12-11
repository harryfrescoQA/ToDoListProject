const params = new URLSearchParams(window.location.search);
 
for(let param of params ){
    let id = param[1];
    console.log(id);
    getData(id)
}


function getData(id){
  

        document.querySelector("input#idInput").value = id
        document
        .querySelector("form.viewRecord")
        .addEventListener("submit", function (stop) {
          stop.preventDefault();
          let formElements = document.querySelector("form.viewRecord").elements;
          console.log(formElements)
      
          let name=formElements["nameInput"].value;
          let message=formElements["messageInput"].value;
      
      
      
          let data = {
            "done": false,
            "fullList": {
              "id": id
            },
            "title":name,
            "message":message
          }
          console.log("Data to post",data)
        
      
          create(data)
          window.location.replace("readList.html?id="+ id);
          // postData(noteTitle,noteBody)
        });
}




  function create(data){
    fetch("http://localhost:9092/item/create", {
        method: 'post',
        headers: {
          "Content-type": "application/json; charset=UTF-8"
        },
        body:JSON.stringify(data)
      })
      .then(function (data) {
        console.log('Request succeeded with JSON response', data);
      })
      .catch(function (error) {
        console.log('Request failed', error);
      });
    }