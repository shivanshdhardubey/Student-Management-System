<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
<meta charset="UTF-8" />
<title>Add Student</title>
<link rel="stylesheet" href="styles.css">
<script src="script.js"></script>
</head>
<body>
<div class="container form-container">
<h2>Add Student</h2>
<form action="AddStudentServlet" method="post" onsubmit="return validateStudentForm();">
<label>Name</label>
<input type="text" name="name" id="name" required>


<label>Roll No</label>
<input type="text" name="roll_no" id="roll_no" required>


<label>Class</label>
<input type="text" name="className" id="className">


<label>Email</label>
<input type="email" name="email" id="email">


<label>Phone</label>
<input type="text" name="phone" id="phone">


<div class="form-actions">
<button type="submit" class="btn">Save</button>
<a class="btn secondary" href="index.jsp">Cancel</a>
</div>
</form>
</div>
</body>
</html>