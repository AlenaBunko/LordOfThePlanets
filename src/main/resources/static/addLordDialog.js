let addLordSubmit = (function () {

 let submitFn = function () {
          let form = document.getElementById('addLordForm');
          form.action = '/addLord';
          form.method = 'POST';
          form.submit();
      };

  let cancelClickEvent = function() {
         let dialog = document.getElementById('addLordDialog');
         dialog.close();
     };


 return {
   submit: submitFn,
   cancelEvent: cancelClickEvent
 }
})();