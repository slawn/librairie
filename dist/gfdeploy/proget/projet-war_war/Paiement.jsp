<%-- 
    Document   : Paiement
    Created on : 14 déc. 2011, 14:48:09
    Author     : Treemo
--%>

<%@include file="template_header.jsp" %>

<%
if ( sessionUser.getPannier().isEmpty() ) {

    %>
    <div align="center">
        <h3>Panier vide</h3>
    </div>
    <%
}
else if ( request.getAttribute("paiement") != null && request.getAttribute("paiement").equals(true) ) {

    %>
    <div align="center">
        <h3>Commande validée</h3>
    </div>
    <%
}
else {
%>
    <div align="center">
        <h3>Paiement</h3>
    </div>

    <form method="post">
        <table style="margin-left:auto;margin-right:auto;">
            <tr>
                <td class="left" style="vertical-align:top;">
                    Type de carte
                </td>

                <td class="right">
                    <select name="ext_frm_cardtype" class="inputtext" style="width:150px;">
                    <option value="" >---&nbsp;</option>
                    <option class="opt_VISA" value="VISA"  >VISA&nbsp;</option>
                    <option class="opt_MASTERCARD" value="MASTERCARD"  >MasterCard&nbsp;</option>
                    <option class="opt_CB" value="CB"  >Carte Bleue&nbsp;</option>
                    </select>

                </td>

                <td></td>
            </tr>

            <tr>
                <td class="left" style="vertical-align:top;">
                    Numéro de carte
                </td>

                <td class="right">
                    <input name="ext_frm_cardnum" autocomplete="off" type="text" maxlength="40" style="width:150px;" class="inputtext" value=""/>
                </td>

                <td></td>
            </tr>

            <tr>
                <td class="left" style="vertical-align:top;">
                    Date d'expiration
                </td>

                <td class="right">
                    <select name="ext_frm_expiry_Month" class="inputselect">
                        <option label="--" value="" title=""  >--</option>
                        <option label="01" value="01" title=""  >01</option>
                        <option label="02" value="02" title=""  >02</option>
                        <option label="03" value="03" title=""  >03</option>
                        <option label="04" value="04" title=""  >04</option>
                        <option label="05" value="05" title=""  >05</option>
                        <option label="06" value="06" title=""  >06</option>
                        <option label="07" value="07" title=""  >07</option>
                        <option label="08" value="08" title=""  >08</option>
                        <option label="09" value="09" title=""  >09</option>
                        <option label="10" value="10" title=""  >10</option>
                        <option label="11" value="11" title=""  >11</option>
                        <option label="12" value="12" selected="selected" title=""  >12</option>
                    </select>

                    <select name="ext_frm_expiry_Year" class="inputselect">
                        <option label="----" value="" title=""  >----</option>
                        <option label="2011" value="2011" selected="selected" title=""  >2011</option>
                        <option label="2012" value="2012" title=""  >2012</option>
                        <option label="2013" value="2013" title=""  >2013</option>
                        <option label="2014" value="2014" title=""  >2014</option>
                        <option label="2015" value="2015" title=""  >2015</option>
                        <option label="2016" value="2016" title=""  >2016</option>
                        <option label="2017" value="2017" title=""  >2017</option>
                        <option label="2018" value="2018" title=""  >2018</option>
                        <option label="2019" value="2019" title=""  >2019</option>
                        <option label="2020" value="2020" title=""  >2020</option>
                        <option label="2021" value="2021" title=""  >2021</option>
                        <option label="2022" value="2022" title=""  >2022</option>
                    </select>
                </td>

                <td></td>
            </tr>

            <tr>
                <td class="left" style="vertical-align:top;">
                    Code CVV2
                </td>

                <td class="right">
                    <input name="ext_frm_cvv" autocomplete="off" type="text" maxlength="4" style="width:50px;" class="inputtext" value=""/>
                    <br />
                </td>

                <td>Ce code à 3 chiffres est généralement situé au dos de votre carte.</td>
            </tr>

            <tr>
                <td colspan="3" style="text-align:center"><input type="submit" value="Payer" /></td>
            </tr>
         </table>
    </form>
    <br />
    <%
    }
%>
<%@include file="template_footer.jsp" %>
