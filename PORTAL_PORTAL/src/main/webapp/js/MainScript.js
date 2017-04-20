/**
 * Created by jemiol on 18.04.17.
 */
$(document).ready(function () {
    addUserDefaultAvatar();
    addMenuGlyphs();
});

function addUserDefaultAvatar() {
    $(".container .content .post .user-profile-avatar").html('<i class="fa fa-user-circle-o" aria-hidden="true"></i>');
}

function addMenuGlyphs() {
    var location = $(".header #nav-menu ul a li");
    $(".header #nav-menu ul a #home").html('<i class="fa fa-home" aria-hidden="true"></i>');
    $(".header #nav-menu ul a #user").html('<i class="fa fa-user-o" aria-hidden="true"></i>');
    $(".header #nav-menu ul a #settings").html('<i class="fa fa-wrench" aria-hidden="true"></i>');
    $(".header #nav-menu ul a #news").html('<i class="fa fa-lightbulb-o" aria-hidden="true"></i>');
}
