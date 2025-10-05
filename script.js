function validateStudentForm(){
var name = document.getElementById('name').value.trim();
var roll = document.getElementById('roll_no').value.trim();
if(!name){ alert('Please enter name'); return false; }
if(!roll){ alert('Please enter roll number'); return false; }
var phone = document.getElementById('phone').value.trim();
if(phone && !/^\+?[0-9\- ]{7,15}$/.test(phone)){ alert('Enter a valid phone'); return false; }
return true;
}