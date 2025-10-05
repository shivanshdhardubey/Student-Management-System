<%@ page import="java.sql.*, javax.sql.*" %>
name = rs.getString("name");
roll_no = rs.getString("roll_no");
className = rs.getString("class");
email = rs.getString("email");
phone = rs.getString("phone");
}
} catch (Exception e) {
e.printStackTrace();
} finally {
try { if (rs!=null) rs.close(); } catch(Exception ignored){}
try { if (ps!=null) ps.close(); } catch(Exception ignored){}
}
}
%>
<html>
<head>
<meta charset="UTF-8" />
<title>Edit Student</title>
<link rel="stylesheet" href="styles.css">
<script src="script.js"></script>
</head>
<body>
<div class="container form-container">
<h2>Edit Student</h2>
<form action="EditStudentServlet" method="post" onsubmit="return validateStudentForm();">
<input type="hidden" name="id" value="<%= id %>">


<label>Name</label>
<input type="text" name="name" id="name" value="<%= name %>" required>


<label>Roll No</label>
<input type="text" name="roll_no" id="roll_no" value="<%= roll_no %>" required>


<label>Class</label>
<input type="text" name="className" id="className" value="<%= className %>">


<label>Email</label>
<input type="email" name="email" id="email" value="<%= email %>">


<label>Phone</label>
<input type="text" name="phone" id="phone" value="<%= phone %>">


<div class="form-actions">
<button type="submit" class="btn">Update</button>
<a class="btn secondary" href="ViewStudentsServlet">Back</a>
</div>
</form>
</div>
</body>
</html>