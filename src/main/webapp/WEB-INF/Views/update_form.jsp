<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="./base.jsp" %>
    </head>
    <body>

        <div class="container mt-3">
            <div class="row">
                <div class="col-md-8 offset-md-2">  
                   <h1 class="text-center mb-3">Change Product Details</h1>
                   <form action="${pageContext.request.contextPath}/handle-product" method="post">
                        <input type="hidden" value="${product.id}" name="id"/>
                        <div class="form-group">
                            <label for="name">Product Name</label>
                            <input type="text" class="form-control" id="name"
                                   aria-describedby="emailHelp" name="title"
                                   placeholder="Enter the Product name here"
                                   value="${product.title}">
                        </div>
                        
                        <div class="form-group">
                            <label for="name">Product Description</label>
                            <textarea class="form-control" id="description"
                                      name="description" rows="5"
                                placeholder="Enter the Product description">${product.description}
                                          
                            </textarea>
                        </div>
                        
                        <div class="form-group">
                            <label for="name">Product Price</label>
                            <input type="number" class="form-control" 
                                   id="name" name="price" 
                                   placeholder="Enter the Product price"
                                   value="${product.price}">
                        </div>
                        
                        <div class="container text-center">
                            <a href="${pageContext.request.contextPath}/"
                               class="btn btn-outline-danger">Back</a>
                               <button type="submit" class="btn bttn-warning">Update</button>
                        </div>
                        
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

