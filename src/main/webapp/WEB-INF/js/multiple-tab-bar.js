var $BODY = $('body'),
    $MENU_TOGGLE = $('#menu_toggle'),
    $SIDEBAR_MENU = $('#sidebar-menu'),
    $SIDEBAR_FOOTER = $('.sidebar-footer'),
    $LEFT_COL = $('.left_col'),
    $RIGHT_COL = $('.right_col'),
    $NAV_MENU = $('.nav_menu'),
    $FOOTER = $('footer');

var menuItemOrder = 0;
const SEPARATOR = "_";

function gfn_sideNavigationBarItemClicked(menuName, url) {
    var menuItemName = menuName + SEPARATOR + (++menuItemOrder);

    $("#tablist > li.active").removeClass('active');
    $("#tablist").append(
        '<li role="presentation" class="active"><a href="#' + menuItemName + '" aria-controls="'
        + menuItemName+ '" role="tab" data-toggle="tab">'
        + '<button class="close closeTab" type="button"><span class="count_top"><i class="fa fa-times"></i></span></button>'
        + menuName + '</a></li>'
    );

    $("#tab_contents > div.tab-pane.active").removeClass('active');
    $("#tab_contents").append(
        '<div role="tabpanel" class="tab-pane active" id="' + menuItemName + '">'
        + '<iframe frameborder="0" class="iframe_container" style="width: 100%; height: 100%; border: margin: 0px;"'
        + 'id="framex" name="framex" scrolling="yes" src="' + url + '"></iframe>'
        + '</div>'
    );

    setContentHeight();
    setTabCloseButtonEvent();
}

function setContentHeight() {
    var iframeTabItem = $('#tab_contents iframe.iframe_container');

    iframeTabItem.css('min-height', $(window).height());

    var bodyHeight = $BODY.outerHeight(),
        footerHeight = $BODY.hasClass('footer_fixed') ? -10 : $FOOTER.height(),
        leftColHeight = $LEFT_COL.eq(1).height() + $SIDEBAR_FOOTER.height(),
        contentHeight = bodyHeight < leftColHeight ? leftColHeight : bodyHeight;

    // normalize content
    contentHeight -= $NAV_MENU.height() + footerHeight;

    iframeTabItem.css('min-height', contentHeight);
}

function setTabCloseButtonEvent() {
    $(".closeTab").click(function() {
        var tabContentId = $(this).parent().attr("href");
        $(this).parent().parent().remove();
        $('#tablist a:last').tab('show');
        $(tabContentId).remove();
    });
}