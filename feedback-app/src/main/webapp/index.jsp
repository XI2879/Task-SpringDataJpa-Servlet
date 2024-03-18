<html>
<head>
    <title>Feedback Form</title>
    <link href="./style.css" type="text/css" rel="stylesheet" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@100..900&family=Mukta:wght@200;300;400;500;600;700;800&family=Nunito:ital,wght@0,200..1000;1,200..1000&display=swap" rel="stylesheet">
</head>
<body>
  <h1>Feedback Form</h1>
  <section>
    <form action="FeedbackServlet" method="post">
        <div class="row">
            <label for="yourName">Your Name</label>
            <input type="text" id="yourName" name="yourName" required>
        </div>
        <div class="row">
            <label for="bookName">Book Name</label>
            <input type="text" id="bookName" name="bookName" required>
        </div>
        <div class="row">
            <label for="feedback">Feedback</label>
            <textarea id="feedback" name="feedback" rows="5" cols="75" required></textarea>
        </div>
        <div class="center">
            <button type="submit" class="primary-btn">Submit</button>
        </div>
    </form>
  </section>
</body>
</html>
