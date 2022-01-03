<%-- 
    Document   : viewCart
    Created on : Dec 28, 2021, 8:29:46 AM
    Author     : jike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <style>
            body {
                background: linear-gradient(110deg, #BBDEFB 60%, #42A5F5 60%)
            }

            .shop {
                font-size: 10px
            }

            .space {
                letter-spacing: 0.8px !important
            }

            .second a:hover {
                color: rgb(92, 92, 92)
            }

            .active-2 {
                color: rgb(92, 92, 92)
            }

            .breadcrumb>li+li:before {
                content: "" !important
            }

            .breadcrumb {
                padding: 0px;
                font-size: 10px;
                color: #aaa !important
            }

            .first {
                background-color: white
            }

            a {
                text-decoration: none !important;
                color: #aaa
            }

            .btn-lg,
            .form-control-sm:focus,
            .form-control-sm:active,
            a:focus,
            a:active {
                outline: none !important;
                box-shadow: none !important
            }

            .form-control-sm:focus {
                border: 1.5px solid #4bb8a9
            }

            .btn-group-lg>.btn,
            .btn-lg {
                padding: .5rem 0.1rem;
                font-size: 1rem;
                border-radius: 0;
                color: white !important;
                background-color: #4bb8a9;
                height: 2.8rem !important;
                border-radius: 0.2rem !important
            }

            .btn-group-lg>.btn:hover,
            .btn-lg:hover {
                background-color: #26A69A
            }

            .btn-outline-primary {
                background-color: #fff !important;
                color: #4bb8a9 !important;
                border-radius: 0.2rem !important;
                border: 1px solid #4bb8a9
            }

            .btn-outline-primary:hover {
                background-color: #4bb8a9 !important;
                color: #fff !important;
                border: 1px solid #4bb8a9
            }

            .card-2 {
                margin-top: 40px !important
            }

            .card-header {
                background-color: #fff;
                border-bottom: 0px solid #aaaa !important
            }

            p {
                font-size: 13px
            }

            .small {
                font-size: 9px !important
            }

            .form-control-sm {
                height: calc(2.2em + .5rem + 2px);
                font-size: .875rem;
                line-height: 1.5;
                border-radius: 0
            }

            .cursor-pointer {
                cursor: pointer
            }

            .boxed {
                padding: 0px 8px 0 8px;
                background-color: #4bb8a9;
                color: white
            }

            .boxed-1 {
                padding: 0px 8px 0 8px;
                color: black !important;
                border: 1px solid #aaaa
            }

            .bell {
                opacity: 0.5;
                cursor: pointer
            }

            @media (max-width: 767px) {
                .breadcrumb-item+.breadcrumb-item {
                    padding-left: 0
                }
            }
        </style>
    </head>
    <body>
        <div class=" container-fluid my-5 ">
            <div class="row justify-content-center ">
                <div class="col-xl-10">
                    <div class="card shadow-lg ">
                        <div class="row p-2 mt-3 justify-content-between mx-sm-2">
                            <div class="col">
                                <p class="text-muted space mb-0 shop"> Shop No.78618K</p>
                                <p class="text-muted space mb-0 shop">Store Locator</p>
                            </div>
                            <div class="col">
                                <div class="row justify-content-start ">
                                    <div class="col"> <img class="irc_mi img-fluid cursor-pointer " src="https://i.imgur.com/jFQo2lD.png" width="70" height="70"> </div>
                                </div>
                            </div>
                            <div class="col-auto"> <img class="irc_mi img-fluid bell" src="https://i.imgur.com/uSHMClk.jpg" width="30" height="30"> </div>
                        </div>
                        <div class="row mx-auto justify-content-center text-center">
                            <div class="col-12 mt-3 ">
                                <nav aria-label="breadcrumb" class="second ">
                                    <ol class="breadcrumb indigo lighten-6 first ">
                                        <li class="breadcrumb-item font-weight-bold "><a class="black-text text-uppercase " href="HomeServlet"><span class="mr-md-3 mr-1">BACK TO SHOP</span></a><i class="fa fa-angle-double-right " aria-hidden="true"></i></li>
                                        <li class="breadcrumb-item font-weight-bold"><a class="black-text text-uppercase active-2" href="#"><span class="mr-md-3 mr-1">CHECKOUT</span></a></li>
                                    </ol>
                                </nav>
                            </div>
                        </div>
                        <div class="row justify-content-around">
                            <div class="col-md-5">
                                <div class="card border-0 ">
                                    <div class="card-header card-2">
                                        <p class="card-text text-muted mt-md-4 mb-2 space">YOUR ORDER <span class=" small text-muted ml-2 cursor-pointer">EDIT SHOPPING BAG</span> </p>
                                        <hr class="my-2">
                                    </div>



                                    <c:set var="items" value="${order.item}"/>
                                    <c:forEach var="item" items="${items}">
                                        <div class="card-body pt-0">
                                            <div class="row justify-content-between">
                                                <div class="col-auto col-md-7">
                                                    <div class="media flex-column flex-sm-row"> <img class=" img-fluid" src="${item.product.image}" width="62" height="62">
                                                        <div class="media-body my-auto">
                                                            <div class="row ">
                                                                <div class="col-auto">
                                                                    <p class="mb-0"><b>${item.product.name}</b></p><small class="text-muted">1 Week Subscription</small>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class=" pl-0 flex-sm-col col-auto my-auto">
                                                    <p class="boxed-1">${item.quantity}</p>
                                                </div>
                                                <div class=" pl-0 flex-sm-col col-auto my-auto ">
                                                    <p><b>${item.price} SEK</b></p>
                                                </div>
                                            </div>
                                        </div>

                                    </c:forEach>
                                    <form action="CheckoutServlet">
                                        <div class="row mb-md-5">
                                            <div class="col"> <button type="submit" name="" id="" class="btn btn-lg btn-block ">PURCHASE ${order.total} SEK</button> </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
