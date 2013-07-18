$(document)
		.ready(
				function() {
					playSpeech("Thanks for visiting State Farm virtual agent, What is your name ");
					setup();
				});

function setup() {
	var recognition = new webkitSpeechRecognition();

	var microphone = document.getElementById("microphone");
	microphone.onfocus = microphone.blur;
	microphone.onwebkitspeechchange = function(e) {
		console.log(e);
		// alert($("#microphone").val());
		$("#inputBox").val("");

		var responses = e.results;

		$(responses)
				.each(
						function() {
							console.log(this.utterance);
							if (this.utterance.indexOf("quote") > -1) {
								playSpeech("What would you like a quote for?");
								$("#inputBox").val(this.utterance);
							}

							if (this.utterance.indexOf("auto") > -1) {
								playSpeech("Can I get year, make and model please?");
								$("#inputBox").val(this.utterance);
							}

							if (this.utterance.indexOf("Ford") > -1) {

								$("#inputBox").val(this.utterance);
								$("#output")
										.html(
												"Calculating..<img style='height: 30px; width: 30px' src='/resources/images/loading.gif'/>");

								setTimeout(
										function() {
											playSpeech("That price will be $52 per month");
											$("#output")
													.html(
															"That price will be $52 per month");
										}, 1000);
							}

							if (this.utterance == "John Doe") {
								playSpeech("Hi John, How can I help you").val(
										this.utterance);
								$("#inputBox").val(this.utterance);
							}

							if (this.utterance.indexOf("Nick") > -1) {
								playSpeech("Hi Nick, How can I help you").val(
										this.utterance);
								$("#inputBox").val(this.utterance);
							}

							if (this.utterance.indexOf("policy") > -1) {
								playSpeech("let me get that information for you");
								$("#inputBox").val(this.utterance);
							}
						});

	};

}

function getData(url) {
	if (url == "")
		url = "expectedJson.js";
	var firstName = "";
	var lastName = "";

	$.getJSON(url, function(data) {
		console.log(data);
		$("#firstName").html(
				"Welcome : " + data.firstName + " " + data.lastName);

	});

}

function playSpeech(input) {
	console.log(input);
	var translateURL = "http://translate.google.com/translate_tts?tl=en&ie=UTF-8&q=";
	var speechToTalk = input.toString();

	var speechArray = speechToTalk.split(" ");
	var outputQuery = "";
	$(speechArray).each(function() {
		outputQuery += this + "%20";
	});

	$("#audioiFrame").attr("src", (translateURL + outputQuery));

	var iframe = document.getElementById("audioiFrame");
	iframe.src = iframe.src;
}
