<%@ page import="java.util.List" %>
<%@ page import="voiture.model.*" %>
<script src="assets/js/format-number.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int nbrUtilisateur = Integer.parseInt(String.valueOf(request.getAttribute("nbrUtilistaeur")));
    double commissionAnnuel = Double.valueOf(String.valueOf(request.getAttribute("commissionAnnuel")));
    double venteAnnuel = Double.valueOf(String.valueOf(request.getAttribute("venteAnnuel")));
    List<VNbventecommissionnbannnonce> listAnnonceAchat = (List<VNbventecommissionnbannnonce>) request.getAttribute("statAnnonceAchat");
    List<BestVendeurDTO> meilleurVendeur = (List<BestVendeurDTO>) request.getAttribute("meilleurVendeur");
    List<V_Marqueplusvendu> meilleurMarque = (List<V_Marqueplusvendu>) request.getAttribute("meilleurMarque");
%>
<!-- header -->
<%@ include file="partials/header.jsp" %>
<body>
<div class="container-scroller">
    <!-- navbar -->
    <%@ include file="partials/navbar.jsp" %>
    <div class="container-fluid page-body-wrapper">
        <!-- sidebar -->
        <%@ include file="partials/sidebar.jsp" %>
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="page-header">
                    <h3 class="page-title">
                        <span class="page-title-icon bg-gradient-primary text-white me-2">
                          <i class="mdi mdi-chart-bar menu-icon"></i>
                        </span>
                        Statistique
                    </h3>
                </div>
                <div class="row">
                    <div class="col-md-4 stretch-card grid-margin">
                        <div class="card bg-gradient-danger card-img-holder text-white">
                            <div class="card-body">
                                <h4 class="font-weight-normal mb-3">Commision Annuel <i class="mdi mdi-cash-multiple mdi-24px float-right"></i>
                                </h4>
                                <h2 class="mb-5">Ar <script>document.write(formaterNombre(<%=commissionAnnuel %>))</script></h2>
                                <h6 class="card-text">Année En Cours</h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 stretch-card grid-margin">
                        <div class="card bg-gradient-info card-img-holder text-white">
                            <div class="card-body">
                                <h4 class="font-weight-normal mb-3">Vente Annuel <i class="mdi mdi-gavel mdi-24px float-right"></i>
                                </h4>
                                <h2 class="mb-5"> <script>document.write(formaterNombre(<%=venteAnnuel %>))</script></h2>
                                <h6 class="card-text">Année En Cours</h6>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4 stretch-card grid-margin">
                        <div class="card bg-gradient-success card-img-holder text-white">
                            <div class="card-body">
                                <h4 class="font-weight-normal mb-3">Nombre Utilisateur <i class="mdi mdi-account-multiple mdi-24px float-right"></i>
                                </h4>
                                <h2 class="mb-5"><script>document.write(formaterNombre(<%=nbrUtilisateur %>))</script></h2>
                                <h6 class="card-text">Jusqu'à présent</h6>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <div class="clearfix">
                                    <h4 class="card-title float-left">Statistique des annonces et achats</h4>
                                    <div id="visit-sale-chart-legend" class="rounded-legend legend-horizontal legend-top-right float-right"></div>
                                </div>
                                <canvas id="visit-sale-chart" class="mt-4"></canvas>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Chiffre d'affaires cette année</h4>
                                <canvas id="lineChart" style="height:250px"></canvas>
                            </div>
                        </div>
                    </div>
                    <%-- <div class="col-md-5 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title"> Type de voiture les plus vendu </h4>
                                <canvas id="traffic-chart"></canvas>
                                <div id="traffic-chart-legend" class="rounded-legend legend-vertical legend-bottom-left pt-4"></div>
                            </div>
                        </div>
                    </div> --%>
                </div>


                <div class="row">
                    <div class="col-12 grid-margin">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Les meilleurs vendeurs</h4>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th> Vendeur </th>
                                            <th> contact </th>
                                            <th> Total vendu </th>
                                            <th> Commision </th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td> <%=meilleurVendeur.get(0).getNom_utilisateur()+" "+meilleurVendeur.get(0).getPrenom_utilisateur()%> </td>
                                            <td> <%=meilleurVendeur.get(0).getTelephone()%> </td>
                                            <td> <%=meilleurVendeur.get(0).getNbvente() %> </td>
                                            <td><script>document.write(formaterNombre(<%=meilleurVendeur.get(0).getChiffre_daffaire() %>))</script> Ar </td>
                                            <td>
                                                <label class="badge badge-gradient-success">Premier</label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td> <%=meilleurVendeur.get(1).getNom_utilisateur()+" "+meilleurVendeur.get(1).getPrenom_utilisateur()%> </td>
                                            <td> <%=meilleurVendeur.get(1).getTelephone()%> </td>
                                            <td> <%=meilleurVendeur.get(1).getNbvente() %> </td>
                                            <td> <script>document.write(formaterNombre(<%=meilleurVendeur.get(1).getChiffre_daffaire() %>))</script> Ar </td>
                                            <td>
                                                <label class="badge badge-gradient-info">Deuxième</label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td> <%=meilleurVendeur.get(2).getNom_utilisateur()+" "+meilleurVendeur.get(2).getPrenom_utilisateur()%> </td>
                                            <td> <%=meilleurVendeur.get(2).getTelephone()%> </td>
                                            <td> <%=meilleurVendeur.get(2).getNbvente() %> </td>
                                            <td> <script>document.write(formaterNombre(<%=meilleurVendeur.get(1).getChiffre_daffaire() %>))</script> Ar </td>
                                            <td>
                                                <label class="badge badge-gradient-danger">Troixième</label>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col-12 grid-margin">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Marques Les plus vendu</h4>
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th> Marque </th>
                                            <th> Vendu </th>
                                            <th> Prix Total  </th>
                                            <th> Commision </th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td> <%=meilleurMarque.get(0).getNom_marque() %> </td>
                                            <td> <%=meilleurMarque.get(0).getQuantitevendu() %> </td>
                                            <td><script>document.write(formaterNombre(<%=meilleurMarque.get(0).getTotalpirx() %>))</script> Ar </td>
                                            <td> <script>document.write(formaterNombre(<%=meilleurMarque.get(0).getCommission() %>))</script> Ar  </td>
                                            <td>
                                                <label class="badge badge-gradient-success">Premier</label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td> <%=meilleurMarque.get(1).getNom_marque() %> </td>
                                            <td> <%=meilleurMarque.get(1).getQuantitevendu() %> </td>
                                            <td><script>document.write(formaterNombre(<%=meilleurMarque.get(1).getTotalpirx() %>))</script> Ar </td>
                                            <td> <script>document.write(formaterNombre(<%=meilleurMarque.get(1).getCommission() %>))</script> Ar  </td>
                                            <td>
                                                <label class="badge badge-gradient-info">Deuxième</label>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td> <%=meilleurMarque.get(2).getNom_marque() %> </td>
                                            <td> <%=meilleurMarque.get(2).getQuantitevendu() %> </td>
                                            <td><script>document.write(formaterNombre(<%=meilleurMarque.get(2).getTotalpirx() %>))</script> Ar </td>
                                            <td> <script>document.write(formaterNombre(<%=meilleurMarque.get(2).getCommission() %>))</script> Ar  </td>
                                            <td>
                                                <label class="badge badge-gradient-danger">Troixième</label>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <!-- footer -->
            <%@ include file="partials/footer.jsp" %>
        </div>
    </div>
</div>
</body>
<!-- import js -->
<%@ include file="partials/import_js.jsp" %>
<script>
    var data_annonce = [<%=listAnnonceAchat.get(0).getNombreAnnonce() %>, <%=listAnnonceAchat.get(1).getNombreAnnonce() %>, <%=listAnnonceAchat.get(2).getNombreAnnonce() %>, <%=listAnnonceAchat.get(3).getNombreAnnonce() %>, <%=listAnnonceAchat.get(4).getNombreAnnonce() %>, <%=listAnnonceAchat.get(5).getNombreAnnonce() %>, <%=listAnnonceAchat.get(6).getNombreAnnonce() %>, <%=listAnnonceAchat.get(7).getNombreAnnonce() %> , <%=listAnnonceAchat.get(8).getNombreAnnonce() %> ,<%=listAnnonceAchat.get(9).getNombreAnnonce() %> ,<%=listAnnonceAchat.get(10).getNombreAnnonce() %> ,<%=listAnnonceAchat.get(11).getNombreAnnonce() %>];
    var data_achat = [<%=listAnnonceAchat.get(0).getNbvente() %>, <%=listAnnonceAchat.get(1).getNbvente() %>, <%=listAnnonceAchat.get(2).getNbvente() %>, <%=listAnnonceAchat.get(3).getNbvente() %>, <%=listAnnonceAchat.get(4).getNbvente() %>, <%=listAnnonceAchat.get(5).getNbvente() %>, <%=listAnnonceAchat.get(6).getNbvente() %>, <%=listAnnonceAchat.get(7).getNbvente() %> , <%=listAnnonceAchat.get(8).getNbvente() %> ,<%=listAnnonceAchat.get(9).getNbvente() %> ,<%=listAnnonceAchat.get(10).getNbvente() %> ,<%=listAnnonceAchat.get(11).getNbvente() %>];
    var data_chiffre_affaire = {
        labels: ['JAN', 'FEV', 'MAR', 'AVR', 'MAI', 'JUIN', 'JUIL', 'AOU' ,'SEP' ,'OCT', 'NOV' , 'DEC'],
        datasets: [{
            label: '# of Votes',
            data: [<%=listAnnonceAchat.get(0).getCommission() %>, <%=listAnnonceAchat.get(1).getCommission() %>, <%=listAnnonceAchat.get(2).getCommission() %>, <%=listAnnonceAchat.get(3).getCommission() %>, <%=listAnnonceAchat.get(4).getCommission() %>, <%=listAnnonceAchat.get(5).getCommission() %>, <%=listAnnonceAchat.get(6).getCommission() %>, <%=listAnnonceAchat.get(7).getCommission() %> , <%=listAnnonceAchat.get(8).getCommission() %> ,<%=listAnnonceAchat.get(9).getCommission() %> ,<%=listAnnonceAchat.get(10).getCommission() %> ,<%=listAnnonceAchat.get(11).getCommission() %>],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1,
            fill: false
        }]
    };
    (function($) {
        'use strict';
        $(function() {

            Chart.defaults.global.legend.labels.usePointStyle = true;

            if ($("#visit-sale-chart").length) {
                Chart.defaults.global.legend.labels.usePointStyle = true;
                var ctx = document.getElementById('visit-sale-chart').getContext("2d");

                var gradientStrokeViolet = ctx.createLinearGradient(0, 0, 0, 181);
                gradientStrokeViolet.addColorStop(0, 'rgba(218, 140, 255, 1)');
                gradientStrokeViolet.addColorStop(1, 'rgba(154, 85, 255, 1)');
                var gradientLegendViolet = 'linear-gradient(to right, rgba(218, 140, 255, 1), rgba(154, 85, 255, 1))';

                var gradientStrokeBlue = ctx.createLinearGradient(0, 0, 0, 360);
                gradientStrokeBlue.addColorStop(0, 'rgba(54, 215, 232, 1)');
                gradientStrokeBlue.addColorStop(1, 'rgba(177, 148, 250, 1)');
                var gradientLegendBlue = 'linear-gradient(to right, rgba(54, 215, 232, 1), rgba(177, 148, 250, 1))';

                var gradientStrokeRed = ctx.createLinearGradient(0, 0, 0, 300);
                gradientStrokeRed.addColorStop(0, 'rgba(255, 191, 150, 1)');
                gradientStrokeRed.addColorStop(1, 'rgba(254, 112, 150, 1)');
                var gradientLegendRed = 'linear-gradient(to right, rgba(255, 191, 150, 1), rgba(254, 112, 150, 1))';

                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ['JAN', 'FEV', 'MAR', 'AVR', 'MAI', 'JUIN', 'JUIL', 'AOU' ,'SEP' ,'OCT', 'NOV' , 'DEC'],
                        datasets: [
                            {
                                label: "Annonce",
                                borderColor: gradientStrokeViolet,
                                backgroundColor: gradientStrokeViolet,
                                hoverBackgroundColor: gradientStrokeViolet,
                                legendColor: gradientLegendViolet,
                                pointRadius: 0,
                                fill: false,
                                borderWidth: 1,
                                fill: 'origin',
                                data: data_annonce
                            },
                            {
                                label: "Achat",
                                borderColor: gradientStrokeRed,
                                backgroundColor: gradientStrokeRed,
                                hoverBackgroundColor: gradientStrokeRed,
                                legendColor: gradientLegendRed,
                                pointRadius: 0,
                                fill: false,
                                borderWidth: 1,
                                fill: 'origin',
                                data: data_achat
                            }
                        ]
                    },
                    options: {
                        responsive: true,
                        legend: false,
                        legendCallback: function(chart) {
                            var text = [];
                            text.push('<ul>');
                            for (var i = 0; i < chart.data.datasets.length; i++) {
                                text.push('<li><span class="legend-dots" style="background:' +
                                    chart.data.datasets[i].legendColor +
                                    '"></span>');
                                if (chart.data.datasets[i].label) {
                                    text.push(chart.data.datasets[i].label);
                                }
                                text.push('</li>');
                            }
                            text.push('</ul>');
                            return text.join('');
                        },
                        scales: {
                            yAxes: [{
                                ticks: {
                                    display: false,
                                    min: 0,
                                    stepSize: 20,
                                    max: 80
                                },
                                gridLines: {
                                    drawBorder: false,
                                    color: 'rgba(235,237,242,1)',
                                    zeroLineColor: 'rgba(235,237,242,1)'
                                }
                            }],
                            xAxes: [{
                                gridLines: {
                                    display:false,
                                    drawBorder: false,
                                    color: 'rgba(0,0,0,1)',
                                    zeroLineColor: 'rgba(235,237,242,1)'
                                },
                                ticks: {
                                    padding: 20,
                                    fontColor: "#9c9fa6",
                                    autoSkip: true,
                                },
                                categoryPercentage: 0.5,
                                barPercentage: 0.5
                            }]
                        }
                    },
                    elements: {
                        point: {
                            radius: 0
                        }
                    }
                })
                $("#visit-sale-chart-legend").html(myChart.generateLegend());
            }
            if ($("#visit-sale-chart-dark").length) {
                Chart.defaults.global.legend.labels.usePointStyle = true;
                var ctx = document.getElementById('visit-sale-chart-dark').getContext("2d");

                var gradientStrokeViolet = ctx.createLinearGradient(0, 0, 0, 181);
                gradientStrokeViolet.addColorStop(0, 'rgba(218, 140, 255, 1)');
                gradientStrokeViolet.addColorStop(1, 'rgba(154, 85, 255, 1)');
                var gradientLegendViolet = 'linear-gradient(to right, rgba(218, 140, 255, 1), rgba(154, 85, 255, 1))';

                var gradientStrokeBlue = ctx.createLinearGradient(0, 0, 0, 360);
                gradientStrokeBlue.addColorStop(0, 'rgba(54, 215, 232, 1)');
                gradientStrokeBlue.addColorStop(1, 'rgba(177, 148, 250, 1)');
                var gradientLegendBlue = 'linear-gradient(to right, rgba(54, 215, 232, 1), rgba(177, 148, 250, 1))';

                var gradientStrokeRed = ctx.createLinearGradient(0, 0, 0, 300);
                gradientStrokeRed.addColorStop(0, 'rgba(255, 191, 150, 1)');
                gradientStrokeRed.addColorStop(1, 'rgba(254, 112, 150, 1)');
                var gradientLegendRed = 'linear-gradient(to right, rgba(255, 191, 150, 1), rgba(254, 112, 150, 1))';

                var myChart = new Chart(ctx, {
                    type: 'bar',
                    data: {
                        labels: ['JAN', 'FEB', 'MAR', 'APR', 'MAY', 'JUN', 'JUL', 'AUG'],
                        datasets: [
                            {
                                label: "CHN",
                                borderColor: gradientStrokeViolet,
                                backgroundColor: gradientStrokeViolet,
                                hoverBackgroundColor: gradientStrokeViolet,
                                legendColor: gradientLegendViolet,
                                pointRadius: 0,
                                fill: false,
                                borderWidth: 1,
                                fill: 'origin',
                                data: [20, 40, 15, 35, 25, 50, 30, 20]
                            },
                            {
                                label: "USA",
                                borderColor: gradientStrokeRed,
                                backgroundColor: gradientStrokeRed,
                                hoverBackgroundColor: gradientStrokeRed,
                                legendColor: gradientLegendRed,
                                pointRadius: 0,
                                fill: false,
                                borderWidth: 1,
                                fill: 'origin',
                                data: [40, 30, 20, 10, 50, 15, 35, 40]
                            },
                            {
                                label: "UK",
                                borderColor: gradientStrokeBlue,
                                backgroundColor: gradientStrokeBlue,
                                hoverBackgroundColor: gradientStrokeBlue,
                                legendColor: gradientLegendBlue,
                                pointRadius: 0,
                                fill: false,
                                borderWidth: 1,
                                fill: 'origin',
                                data: [70, 10, 30, 40, 25, 50, 15, 30]
                            }
                        ]
                    },
                    options: {
                        responsive: true,
                        legend: false,
                        legendCallback: function(chart) {
                            var text = [];
                            text.push('<ul>');
                            for (var i = 0; i < chart.data.datasets.length; i++) {
                                text.push('<li><span class="legend-dots" style="background:' +
                                    chart.data.datasets[i].legendColor +
                                    '"></span>');
                                if (chart.data.datasets[i].label) {
                                    text.push(chart.data.datasets[i].label);
                                }
                                text.push('</li>');
                            }
                            text.push('</ul>');
                            return text.join('');
                        },
                        scales: {
                            yAxes: [{
                                ticks: {
                                    display: false,
                                    min: 0,
                                    stepSize: 20,
                                    max: 80
                                },
                                gridLines: {
                                    drawBorder: false,
                                    color: '#322f2f',
                                    zeroLineColor: '#322f2f'
                                }
                            }],
                            xAxes: [{
                                gridLines: {
                                    display:false,
                                    drawBorder: false,
                                    color: 'rgba(0,0,0,1)',
                                    zeroLineColor: 'rgba(235,237,242,1)'
                                },
                                ticks: {
                                    padding: 20,
                                    fontColor: "#9c9fa6",
                                    autoSkip: true,
                                },
                                categoryPercentage: 0.5,
                                barPercentage: 0.5
                            }]
                        }
                    },
                    elements: {
                        point: {
                            radius: 0
                        }
                    }
                })
                $("#visit-sale-chart-legend-dark").html(myChart.generateLegend());
            }

            //-----------------------------------------------------------------------------------------

            var options = {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                },
                legend: {
                    display: false
                },
                elements: {
                    point: {
                        radius: 0
                    }
                }

            };

            if ($("#lineChart").length) {
                var lineChartCanvas = $("#lineChart").get(0).getContext("2d");
                var lineChart = new Chart(lineChartCanvas, {
                    type: 'line',
                    data: data_chiffre_affaire,
                    options: options
                });
            }

            //---------------------------------------------------------------------------------------


            if ($("#traffic-chart").length) {
                var gradientStrokeBlue = ctx.createLinearGradient(0, 0, 0, 181);
                gradientStrokeBlue.addColorStop(0, 'rgba(54, 215, 232, 1)');
                gradientStrokeBlue.addColorStop(1, 'rgba(177, 148, 250, 1)');
                var gradientLegendBlue = 'linear-gradient(to right, rgba(54, 215, 232, 1), rgba(177, 148, 250, 1))';

                var gradientStrokeRed = ctx.createLinearGradient(0, 0, 0, 50);
                gradientStrokeRed.addColorStop(0, 'rgba(255, 191, 150, 1)');
                gradientStrokeRed.addColorStop(1, 'rgba(254, 112, 150, 1)');
                var gradientLegendRed = 'linear-gradient(to right, rgba(255, 191, 150, 1), rgba(254, 112, 150, 1))';

                var gradientStrokeGreen = ctx.createLinearGradient(0, 0, 0, 300);
                gradientStrokeGreen.addColorStop(0, 'rgba(6, 185, 157, 1)');
                gradientStrokeGreen.addColorStop(1, 'rgba(132, 217, 210, 1)');
                var gradientLegendGreen = 'linear-gradient(to right, rgba(6, 185, 157, 1), rgba(132, 217, 210, 1))';

                var trafficChartData = {
                    datasets: [{
                        data: [105, 49, 200],
                        backgroundColor: [
                            gradientStrokeBlue,
                            gradientStrokeGreen,
                            gradientStrokeRed
                        ],
                        hoverBackgroundColor: [
                            gradientStrokeBlue,
                            gradientStrokeGreen,
                            gradientStrokeRed
                        ],
                        borderColor: [
                            gradientStrokeBlue,
                            gradientStrokeGreen,
                            gradientStrokeRed
                        ],
                        legendColor: [
                            gradientLegendBlue,
                            gradientLegendGreen,
                            gradientLegendRed
                        ]
                    }],

                    // These labels appear in the legend and in the tooltips when hovering different arcs
                    labels: [
                        'SUV',
                        'Couper',
                        'Cabriolet',
                    ]
                };
                var trafficChartOptions = {
                    responsive: true,
                    animation: {
                        animateScale: true,
                        animateRotate: true
                    },
                    legend: false,
                    legendCallback: function(chart) {
                        var text = [];
                        text.push('<ul>');
                        for (var i = 0; i < trafficChartData.datasets[0].data.length; i++) {
                            text.push('<li><span class="legend-dots" style="background:' +
                                trafficChartData.datasets[0].legendColor[i] + '"></span>');
                            if (trafficChartData.labels[i]) {
                                text.push(trafficChartData.labels[i]);
                            }
                            text.push('<span class="float-right">'+" "+trafficChartData.datasets[0].data[i]+" ventes "+'</span>')
                            text.push('</li>');
                        }
                        text.push('</ul>');
                        return text.join('');
                    }
                };
                var trafficChartCanvas = $("#traffic-chart").get(0).getContext("2d");
                var trafficChart = new Chart(trafficChartCanvas, {
                    type: 'doughnut',
                    data: trafficChartData,
                    options: trafficChartOptions
                });
                $("#traffic-chart-legend").html(trafficChart.generateLegend());
            }
        });
    })(jQuery);

</script>

</html>