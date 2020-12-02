<jsp:useBean id="reimb" scope="request" class="com.revature.models.Reimbursement"/>
<%@ page import="com.revature.models.Reimbursement" %>
<html>


<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
    <title>Reimb (Backup 1605894679392) (Backup 1606836345474)</title>
</head>

<body>

<div class="datagrid">
    <table class="table">
        <thead>
        <tr>
            <th>Amount</th>
            <th>Description</th>
            <th>Author</th>
            <th>status</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <jsp:useBean id="reimbursements" scope="request" type="java.util.List"/>

            <td>${reimb.amount}</td>
            <td>${reimb.description}</td>
            <td>${reimb.authorID}</td>
            <td>${reimb.status}</td>

        </tr>
        </tbody>
        <tfoot>
        <tr>
            <td colspan="4">
                <div class="paging">
                    <ul>
                        <li><a href="#"><span>Previous </span></a></li>
                        <li><a class="active" href="#"><span>1 </span></a></li>
                        <li><a href="#"><span>2 </span></a></li>
                        <li><a href="#"><span>3</span></a></li>
                        <li><a href="#"><span>Next </span></a></li>
                    </ul>
                </div>
            </td>
        </tr>
        </tfoot>
    </table>
</div>
</body>

</html>