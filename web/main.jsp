<%-- 
    Document   : main
    Created on : Sep 7, 2025, 6:17:40 PM
    Author     : Akila Perera
--%>

<%@page import="dao.leaderDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="util.DBconnection" %>
<%@ page import="dao.mainDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NSBM TABLE TENNIS CLUB</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
        <link rel="stylesheet" href="mainCss.css">
    </head>
    <body>
        
        <nav class="navbar">
        <div class="nav-container">
            <div class="logo-container">
                <img class="logo" src="mainImage?id=1" alt="Logo">
                <div class="brand">NSBM TABLE TENNIS CLUB</div>
            </div>
            
            <button class="menu-toggle" id="menuToggle">
                <i class="fas fa-bars"></i>
            </button>
            
            <ul class="navlist" id="navList">
                <li><a href="#about">About Us</a></li>
                <li><a href="#vision">Vision</a></li>
                <li><a href="#contact">Contact Us</a></li>
                <li><a href="#join" class="cta-button">Join Now</a></li>
                <li><a href="login.html" class="cta-button">Login</a></li>
            </ul>
        </div>
    </nav>

    <section class="hero">
        <div class="hero-content">
            <h1>Welcome To<br>NSBM Table Tennis Club</h1>
            <p>Join our vibrant community of table tennis enthusiasts and experience the thrill of the game!</p>
            <a href="studentForm.jsp" class="cta-button large">Join Now</a>
        </div>
        <div class="hero-image">
            <img  src="mainImage?id=2" alt="Cover">
        </div>
    </section>

    <section id="about" class="section">
        <div class="container">
            <h2 class="section-title">About Us</h2>
            <div class="about-content">
                <div class="about-text">
                    <p>
                        <%
                            mainDAO about= new mainDAO();
                            String ab= about.about(3);
                            %>
                            <%=ab%>
                    </p>
                </div>
                <div class="about-images">
                <div class="about-image">
                    <img src="mainImage?id=3" alt="Table tennis match at NSBM">
                </div>
                <div class="about-image">
                    <img src="mainImage?id=4" alt="Table tennis match at NSBM">
                </div>
                    
                    </div>
                <div class="about-images">
                <div class="about-image">
                    <img src="mainImage?id=5" alt="Table tennis match at NSBM">
                </div>
                <div class="about-image">
                    <img src="mainImage?id=6" alt="Table tennis match at NSBM">
                </div>
                    
                    </div>
                
            </div>
        </div>
    </section>

    <section id="vision" class="section">
        <div class="container">
            <h2 class="section-title">Our Vision</h2>
            <div class="vision-content">
                
                <div class="vision-text">
                    <p><%String vi= about.about(7);
                            %>
                            <%=vi%></p>
                    
                </div>
                <div class="vision-image">
                    <img src="mainImage?id=7" alt="Table tennis match at NSBM">
                </div>
            </div>
        </div>
    </section>
    
    <section id="achievements" class="section">
    <div class="container">
        <h2 class="section-title">Our Achievements</h2>
        <p class="section-subtitle">Celebrating our successes and milestones</p>
        
        <div class="accordion">
            
            
            <div class="accordion-item">
                <button class="accordion-header">
                    <span>2024</span>
                    <i class="fas fa-chevron-down"></i>
                </button>
                <div class="accordion-content">
                    <div class="achievement-details">
                        <img src="Images/ac2024.jpg" alt="2024 achivment">
                        <div class="achievement-text">
                            <h3> NSBM SPORTS FIESTA 2024</h3>
                            
                            <ul>
                                <li>
                                    Champions    –  Ruby Adventures (Boys) / Citrine Warriors (Girls)
                                    
                                    </li>
                                <li>Runners up    –   Citrine Warriors (Boys) / Ruby Adventures (Girls)</li>
                                <li>2nd Runner up –  Emerald Fighters (Boys) / Emerald Fighters (Girls)</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="accordion-item">
                <button class="accordion-header">
                    <span>2023</span>
                    <i class="fas fa-chevron-down"></i>
                </button>
                <div class="accordion-content">
                    <div class="achievement-details">
                        <img src="Images/ac2023p1.jpg" alt="2023 achivment">
                        <div class="achievement-text">
                            <h3>  USPORTS 2023</h3>
                            <ul>
                                <li>   Champions – Mixed A Team</li>
                                <li>   Champions – Women’s Team</li>
                                
                            </ul>
                             <h3>NSBM SPORTS FIESTA 2023</h3>
                            <ul>
                                <li> Champions    – Emerald Fighters (Boys) / Sapphire Heroes (Girls)</li>
                                <li>   1st Runners up    – Sapphire Heroes (Boys) / Ruby Adventures (Girls)</li>
                                <li> 2nd Runner up – Citrine Warriors (Boys) / Emerald Fighters (Girls) </li>
                                
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            
            
        </div>
    </div>
</section>
                            <%leaderDAO leader= new leaderDAO();%>
    <section id="messages" class="section">
    <div class="container">
        <h2 class="section-title">Leadership Messages</h2>
        <p class="section-subtitle">Words from our dedicated leaders</p>
        
        <div class="messages-container">
            <div class="message-card">
                <div class="message-photo">
                    <img src="leaderImage?id=1" alt="Club President">
                    <div class="message-info">
                        <div class="message-role">President</div>
                        <h3 class="message-name"><%=leader.title(1)%>. <%=leader.name(1)%></h3>
                    </div>
                </div>
                <div class="message-content">
                    <div class="message-icon">
                        <i class="fas fa-quote-left"></i>
                    </div>
                    <%
                            
                            String msg1= leader.leader(1);
                            %>
                            <p> <%=msg1%></p>
                    <div class="message-signature">
                        
                        <span><%=leader.name(1)%></span>
                    </div>
                </div>
            </div>
            
            <div class="message-card">
                <div class="message-photo">
                    <img src="leaderImage?id=2" alt="Club President">
                    <div class="message-info">
                        <div class="message-role">Master in Charge</div>
                        <h3 class="message-name"><%=leader.title(2)%>. <%=leader.name(2)%></h3>
                    </div>
                </div>
                <div class="message-content">
                    <div class="message-icon">
                        <i class="fas fa-quote-left"></i>
                    </div>
                    <%
                            
                            String msg2= leader.leader(1);
                            %>
                            <p> <%=msg2%></p>
                    <div class="message-signature">
                        
                        <span><%=leader.name(2)%></span>
                    </div>
                </div>
            </div>
                    <div class="message-card">
                <div class="message-photo">
                    <img src="leaderImage?id=3" alt="Club President">
                    <div class="message-info">
                        <div class="message-role">Master in Charge</div>
                        <h3 class="message-name"><%=leader.title(3)%>. <%=leader.name(3)%></h3>
                    </div>
                </div>
                <div class="message-content">
                    <div class="message-icon">
                        <i class="fas fa-quote-left"></i>
                    </div>
                    <%
                            
                            String msg3= leader.leader(3);
                            %>
                            <p> <%=msg3%></p>
                    <div class="message-signature">
                        
                        <span><%=leader.name(3)%></span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
    <section id="join" class="section cta-section">
        <div class="container">
            <h2>Ready to Join?</h2>
            <p>Become a part of our growing table tennis community</p>
            <a href="studentForm.jsp" class="cta-button large">Join Now</a>
        </div>
    </section>

    <section id="contact" class="section">
        <div class="container">
            <h2 class="section-title">Contact Us</h2>
            <div class="contact-content">
                <div class="contact-info">
                    <h3>Get in Touch</h3>
                    <div class="info-item">
                        <i class="fas fa-map-marker-alt"></i>
                        <span>NSBM Green University, Mahenwaththa, Pitipana, Homagama</span>
                    </div>
                    <div class="info-item">
                        <i class="fas fa-envelope"></i>
                        <span>ttclub@nsbm.lk</span>
                    </div>
                    <div class="info-item">
                        <i class="fas fa-phone"></i>
                        <span>+94 11 544 5000</span>
                    </div>
                    <div class="info-item">
                        <i class="fas fa-clock"></i>
                        <span>Training Sessions: Mon, Wed, Fri 4 PM - 7 PM</span>
                    </div>
                </div>
                <div class="contact-form">
                    <h3>Send us a Message</h3>
                    <form action="send_message" method="post" name="msg">
                        <div class="form-group">
                            <label for="name">Your Name</label>
                            <input type="text" name="name" placeholder="Enter your name" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email Address</label>
                            <input type="email" name="mail" placeholder="Enter your email" required>
                        </div>
                        <div class="form-group">
                            <label for="message">Message</label>
                            <textarea name="msg" placeholder="Type your message here" required></textarea>
                        </div>
                        <button type="submit" class="cta-button">Send Message</button>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <footer>
        <div class="container">
            <p>&copy; 2025 NSBM Table Tennis Club. All rights reserved.</p>
        </div>
    </footer>

    <script src="Script/script.js"></script>
    </body>
</html>
