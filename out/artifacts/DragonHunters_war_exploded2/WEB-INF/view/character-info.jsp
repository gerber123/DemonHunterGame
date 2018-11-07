<%--
  Created by IntelliJ IDEA.
  User: gerber
  Date: 04.11.2018
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/resources/css/character-statistic.css">
    <link href="https://fonts.googleapis.com/css?family=Cinzel" rel="stylesheet"><style type="text/css">
</style>

</head>
<body>
<!-- Learn about this code on MDN: https://developer.mozilla.org/pl/docs/Web/CSS/CSS_Grid_Layout -->

<div class="body">
    <div class="header"><h1>EveryOne  must <span style="color:red">Die</span>. EveryWhere is <span style="color:red">death</span></h1></div>
    <div class="left-bar">
       <h3> <div class="h3-without-shadow"><span style="color:red; font-size:23px">Character Info</span></div></h3>
        <c:if test="${userCharacter.characterRace.id==1}">
            <c:if test="${userCharacter.characterType.id==1}">
        <img src="${pageContext.request.contextPath}/resources/images/logo-panel/human-hunter.jpg" class="image-leftbar"/>
            </c:if>
            <c:if test="${userCharacter.characterType.id==2}">
        <img src="${pageContext.request.contextPath}/resources/images/logo-panel/human-mage.jpg" class="image-leftbar"/>
            </c:if>
            <c:if test="${userCharacter.characterType.id==3}">
        <img src="${pageContext.request.contextPath}/resources/images/logo-panel/human-warrior.jpg" class="image-leftbar"/>
            </c:if>
        </c:if>
        <c:if test="${userCharacter.characterRace.id==2}">
            <c:if test="${userCharacter.characterType.id==1}">
        <img src="${pageContext.request.contextPath}/resources/images/logo-panel/elf-hunter.jpg" class="image-leftbar"/>
            </c:if>
            <c:if test="${userCharacter.characterType.id==2}">
        <img src="${pageContext.request.contextPath}/resources/images/logo-panel/elf-mage.jpg" class="image-leftbar"/>
            </c:if>
            <c:if test="${userCharacter.characterType.id==3}">
        <img src="${pageContext.request.contextPath}/resources/images/logo-panel/elf-warrior.jpg" class="image-leftbar"/>
            </c:if>
        </c:if>
        <c:if test="${userCharacter.characterRace.id==3}">
            <c:if test="${userCharacter.characterType.id==1}">
        <img src="${pageContext.request.contextPath}/resources/images/logo-panel/orc-hunter.jpg" class="image-leftbar"/>
            </c:if>
            <c:if test="${userCharacter.characterType.id==2}">
        <img src="${pageContext.request.contextPath}/resources/images/logo-panel/orc-mage.jpg" class="image-leftbar"/>
            </c:if>
            <c:if test="${userCharacter.characterType.id==3}">
        <img src="${pageContext.request.contextPath}/resources/images/logo-panel/orc-warrior.png" class="image-leftbar"/>
            </c:if>
        </c:if>
        <c:if test="${userCharacter.characterRace.id==4}">
            <c:if test="${userCharacter.characterType.id==1}">
        <img src="${pageContext.request.contextPath}/resources/images/logo-panel/dwarf-hunter.jpg" class="image-leftbar"/>
            </c:if>
            <c:if test="${userCharacter.characterType.id==2}">
        <img src="${pageContext.request.contextPath}/resources/images/logo-panel/dwarf-mage.png" class="image-leftbar"/>
            </c:if>
            <c:if test="${userCharacter.characterType.id==3}">
        <img src="${pageContext.request.contextPath}/resources/images/logo-panel/dwarf-warrior.jpg" class="image-leftbar"/>
            </c:if>
        </c:if>
        <h3><span style="color:yellow">Name:</span> ${userCharacter.nick_name}</h3>
        <h3><span style="color:yellow">Hp:</span> ${userCharacter.characterDetail.actual_hp}/${userCharacter.characterDetail.max_hp}</h3>
        <h3><span style="color:yellow">Energy:</span> ${userCharacter.characterDetail.actual_energy}/${userCharacter.characterDetail.max_energy}</h3>
        <h3><span style="color:yellow">Lvl:</span> ${userCharacter.lvl}</h3>
        <h3><span style="color:yellow">Exp:</span> ${userCharacter.characterDetail.actual_exp}/${userCharacter.characterDetail.max_exp}</h3>
        <h3><span style="color:red; font-size:23px">Character Panel</span></h3>
        <a href="${pageContext.request.contextPath}/character/characterInfo"><h3><span style="color:yellow"> Statistics</span></h3></a>
        <a href="${pageContext.request.contextPath}/character/characterEquipment"><h3><span style="color:yellow">Equipment</span></h3></a>
        <h3><span style="color:yellow">Inventory</span></h3>
        <h3><span style="color:yellow">Guild</span></h3>
        <h3><span style="color:yellow">Friends</span></h3>
        <h3><span style="color:red; font-size:23px">Account</span></h3>
        <h3><span style="color:yellow">Account manager</span></h3>

            <form:form action="${pageContext.request.contextPath}/logout">
                <h3><input type="submit" style="margin:30%; margin-top:0px;" value="logout" class="h3-without-shadow"> </h3>
        </form:form>



    </div>

    <div class="body-center">

        <h1><span style="color:red">Statistics make your own Balance!</span></h1>
      <c:if test="${characterStats.stat_free_points!=0}">
          <h2>
              You have <span style="color:red">${characterStats.stat_free_points}</span> points to manage them
          </h2>
        </c:if>
            <c:if test="${characterStats.stat_free_points==0}">
                <h2>
                    You don't have <span style="color:red">points</span> to manage them.
                </h2>
            </c:if>

            <form:form action="${pageContext.request.contextPath}/character/strIncrease?StatIncrease=1"
                       modelAttribute="characterStats"
                       class="form-horizontal">

                <div class="h3-without-shadow-stat"><span style="color:yellow">Strength:</span> ${characterStats.stat_str}
                    <input type="submit" value="+" class="button"></div>
            </form:form>

            <form:form action="${pageContext.request.contextPath}/character/dexIncrease?StatIncrease=1"
                       modelAttribute="characterStats"
                       class="form-horizontal">
                <div class="h3-without-shadow-stat"><span style="color:yellow">Dexterity:</span> ${characterStats.stat_dex}
                <input type="submit" value="+" class="button"></div>
            </form:form>
            <form:form action="${pageContext.request.contextPath}/character/conIncrease?StatIncrease=1"
                       modelAttribute="characterStats"
                       class="form-horizontal">
                <div class="h3-without-shadow-stat"><span style="color:yellow">Concentration:</span> ${characterStats.stat_con}
                    <input type="submit" value="+" class="button"></div>
            </form:form>
            <form:form action="${pageContext.request.contextPath}/character/intIncrease?StatIncrease=1"
                       modelAttribute="characterStats"
                       class="form-horizontal">
                <div class="h3-without-shadow-stat"><span style="color:yellow">Intelligence:</span> ${characterStats.stat_int}
                    <input type="submit" value="+" class="button"></div>
            </form:form>
            <form:form action="${pageContext.request.contextPath}/character/wigIncrease?StatIncrease=1"
                       modelAttribute="characterStats"
                       class="form-horizontal">
                <div class="h3-without-shadow-stat"><span style="color:yellow">Wigor:</span> ${characterStats.stat_wig}
                    <input type="submit" value="+" class="button"></div>
            </form:form>
        <h1><span style="color:red">Basic Information</span></h1>
            <div class="h3-without-shadow-stat">
                <span style="color:yellow"> Attack:</span> ${userCharacter.characterDetail.attack}&nbsp;&nbsp;&nbsp; <span style="color:yellow">Magic Attack: </span>${userCharacter.characterDetail.m_attack} &nbsp;&nbsp;&nbsp; <span style="color:yellow"> Def:</span> ${userCharacter.characterDetail.defense}
            </div> <div class="h3-without-shadow-stat"> <span style="color:yellow">Health:</span> ${userCharacter.characterDetail.max_hp} &nbsp;&nbsp;&nbsp; <span style="color:yellow">Energy:</span> ${userCharacter.characterDetail.max_energy}
        &nbsp;&nbsp;&nbsp; <span style="color:yellow">Crit Damage:</span> ${userCharacter.characterDetail.crit_damage} </div>
        <div class="h3-without-shadow-stat"> <span style="color:yellow">Crit Chance:</span> ${userCharacter.characterDetail.crit_chance}
            &nbsp;&nbsp;&nbsp; <span style="color:yellow">Accuracy:</span> ${userCharacter.characterDetail.accuracy} &nbsp;&nbsp;&nbsp;  <span style="color:yellow">Avoid:</span> ${userCharacter.characterDetail.chance_avoid}
            </div>


    </div>
    <div class="right-bar">

        <h3><span style="color:red; font-size:23px">Grinding</span></h3>
        <h3><span style="color:yellow">Monsters</span></h3>
        <h3><span style="color:yellow">Raids</span></h3>
        <h3><span style="color:yellow">Dungeons</span></h3>
        <h3><span style="color:yellow">Lucky dragon</span></h3>

        <h3><span style="color:red; font-size:23px">Shop</span></h3>
        <h3><span style="color:yellow">Blackmisth</span></h3>
        <h3><span style="color:yellow">Grocerry Shop</span></h3>
        <h3><span style="color:yellow">Accessory Shop</span></h3>
        <h3><span style="color:yellow">Black Market</span></h3>
        <h3><span style="color:yellow">Vendor</span></h3>


        <h3><span style="color:red; font-size:23px">PVP</span></h3>
        <h3><span style="color:yellow">Colloseum</span></h3>
        <h3><span style="color:yellow">Lucky Fight</span></h3>
        <h3><span style="color:yellow">Hide and Kill</span></h3>
        <h3><span style="color:yellow">Guild war</span></h3>


        <h3><span style="color:red; font-size:23px">Support</span></h3>
        <h3><span style="color:yellow">Technical Problem</span></h3>
        <h3><span style="color:yellow">Email to support</span></h3>
        <h3><span style="color:yellow">Candidate to be GM</span></h3>
        <h3><span style="color:yellow">Report Other Player</span></h3>


    </div>
</div>
</body>
</html>
