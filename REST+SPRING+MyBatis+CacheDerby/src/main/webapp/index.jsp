<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<body>
	<h1>File Upload</h1>
 
	<form action="rest/file/upload" method="post" enctype="multipart/form-data">
 	   <p>
		Select a file : <input type="file" name="file" size="45" />
	   </p>
	   <input type="submit" value="Upload It" />
	</form>
        
        <form action="rest/file/download" method="get">
	   <input type="submit" value="Download It" />
	</form>
        
        <form action="rest/file/select" method="post">
		<p>
		Payment level : <input type="text" name="level" />
		</p>
		<input type="submit" value="Result" />
	</form>
 
</body>
</html>
