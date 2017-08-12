$(function() {

	// fixing menu select problem 
	switch (menu) {

	case 'Contact Us':
		$('#contact').addClass('active');
		break;

	case 'About Us':
		$('#about').addClass('active');
		break;

	default:
		$('#home').addClass('active');
		break;
	}

});