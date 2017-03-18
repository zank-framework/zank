# zank
main core

![zank framework](https://raw.githubusercontent.com/zank-framework/zank/master/zank.png)

<div dir="rtl">
 طرح قصه
 
قصه فرم ورک وبی که اسمش ضنک هست را در زیر شرح می دهم باشد که این نوشته چراغ راهی برای شناسایی بهتر ضنک باشد.

هدف اصلی

هدف اصلی از ساختش حذف مدل MVC از مدل فعلی طراحی نرم افزار هست که به نظر من تو حوزه وب دیگه باید جای خودش رو به چیزهایه دیگه بده...
من به حوزه هایی مثل دسکتاپ و موبایل فعلا فکر نمی کنم، تمام تمرکزم حذف یک سری از درخواست‌های کلاینت به سرور و بالعکس برای ارتباطات بخش سرور ساید موجود در سرور و اینترفیس اجرا شده در سمت کلاینت در پروتکل http هست.

MVC

برای آشنایی کوتاهی با مدل MVC یه توضیح کوچیک می نویسم...
در مدل MVC برای خلاص شدن از ارتباطات مستقیم اینترفیس با جدول پایگاه داده چند مفهوم تعریف می شود، ۱)مفهوم مدل۲)مفهوم کنترلر۳)مفهوم اینترفیس
شما با استفاده از مدل، آبجکتی از جدول پایگاه داده خواهید داشت که در کنترلر فراخور فانکشن‌های مدنظرتون از اونها به عنوان یک آبجکت چه به شکل Lazy Load و چه به شکل Cach شده استفاده می کنید.
در این مدل به دلیل سادگی و یکپارچگی و از همه مهمتر تفکیک پذیری بالا طرافداران بسیاری را در زبان های ASP و J2EE داره(البته دیگر زبان های نو پایی مثل روبی و گریلز و پی‌تون هم همین مدل یا مدلی شبیه به همین داستان را دارند)

طرح مشکل

حالا مشکلی که در وب به خصوص وب با پهنای باند پایین داریم، کانکشن های بسیار بالا به پایگاه داده از اینترفیس مشتری است، اگر از ولیدیشن‌ها هم بگذریم و مستقیم به کلاینت ارجاع دهیم(که البته هنوز هم هستند برنامه نویسانی که ولیدیشن حتی ایمیل رو در سرورساید انجام می‌دن.)،  کانکشن‌های بسیاری هستند که به شکل سیشن بیس برای هر سیشنی که کاربر باز می کند ساخته می شود، لذا سربار محاسباتی و ارتباطی با پایگاه داده به شدت در این مدل بالاست، که با چند برابر شدن کابران با مشکلات سنگین دیگر مواجه خواهند شد که عملا با شگردهای لودبالانسینگ و یا حتی شگردهای افزایش بهینگی جداول پایگاه داده سعی در برطرف کردن افت سرعت ایجاد شده هستند.

سوال اصلی

حال چگونه می شود از این فرایند که ظاهرا هم بدون هیچ راه حلی می بایست از آن استفاده کرد، خلاص شد؟ چگونه می توان بدون در نظر گرفتن ارتباط با پایگاه داده از یک وب دینامیک برخوردار بود؟
پاسخی که من برای این سوال پیدا کردم و در دو مساله هم پیاده کرده ام به شکل زیر است، 
برای حذف این ارتباط یک مدل سه لایه به شکل زیر طراحی کرده ام:
https://github.com/zank-framework/zank
این مدل از سه باکس طراحی شده است، 
ما با استفاده از این مدل سعی داریم با تنظیم کردن هوشمند یا به شکل دستی قسمت syncronizer مشکل ارتباط پایگاه داده را حل کنیم.

تغیر نگاه

اجازه دهید شفاف تر توضیح دهم...
این فرم ورک ابتدا توسط قسمت ORM به عنوان وندور کانکتور به پایگاه داده دیتای ذخیره شده در پایگاه داده را بازخوانی می کند.
عملیات خواندن دیتا از دیتا بیس توسط قسمت Syncronizer شروع  می شود، به این شکل با استفاده از این قسمت کل پایگاه داده با توجه به دوره های زمانی که به شکل هوشمند تنظیم می شود و یا حتی در بخش تنظیمات به شکل دستی تنظیم می شود(یک ساعت یکبار، یک روز یکبار و ...) سپس این دیتا به قسمت generator می رود.
 بر اساس معماری عناصر و موجودیت ها و ارتباطاتی که در اینرفیس دارید و در قسمت generator توسط برنامه نویس نهایی تنظیم و نوشته می شود، و بر اساس دیتای ارسال شده از قسمت Syncronizer ، داده ها بر روی قالب نهایی می نشینند.
 
 مثال
 
اجازه دهید یک مثال ساده بزنم...
یک سایت فروشگاهی یا خبری یا ویکی یا تبلیغاتی یا حتی اپلیکیشن خاص وبی را در نظر بگیرید.
این سایت از صفحات دینامیک با پارامترهای خاص ساخته شده است.
example.com/category?id=123
که با هر بار فراخوانی توسط هر کاربر یک بار فرایند زیر انجام می شود:
درخواست صفحه توسط کاربر(بدون هزینه زمانی)
انتقال درخواست از کلاینت به سرور(هزینه بر)
درخواست دیتا از پایگاه داده (هزینه بر و به شدت وابسته به سرعت پایگاه داده، و نحوه برنامه نویسی توسعه دهنده)
ساخت صفحه کاربر به شکل دینامیک در سرور(هزینه بر)
انتقال دیتا از سرور به کلاینت(بدون هزینه. البته با چشم پوشی از هزینه پهنای باند که کاربر بیچاره می بایست مثل من به شاتل پرداخت کند.)
حال با توجه به این زمانی که در گام سوم تا گام آخر هزینه می شود توجیه تولید فرم ورک مستقل از پایگاه داده آنلاین را به شکل روشنی نمایش می دهد.

مدل پایگاه داده آفلاین

البته مدل پایگاه داده آفلاین قبلا به شکل های دیگری استفاده می شد، ولی در این فرم ورک سعی در ارائه یک راه حل منطبق با حوزه وب هستیم.
به شکل مفید و مختصر می توان به این شکل گفت که ضنک چنین می کند:
به جای تولید صفحات دینامیک به اضای هر کاربر و در هر سیشن
یکبار تولید کل صفحات دینامیک و تبدیل آنها توسط قسمت generator به صفحات استاتیک و حذف زمانی که از گام سوم تا گام آخر در این مثال بالا ایجاد می شود
که اگر مثلا یک سایت خبری یا فروشگاهی با ۱ میلیون بازدید در نظر بگیرید و این بازدید را در بهترین زمان قابل تصور ینی ۱ ثاینه کنید، بازهم در زمان بسیار بالایی از سرور صرفه جویی شده است.

نتیجه

نتیجه نهایی استفاده از ضنک به این شکل خواهد شد که شما با کاهش استفاده از منابع سرور (به شکل مستقیم رم و سی‌پی‌یو) صرفا صفحات استاتیک را به کاربر نشان خواهید داد و لذا عملا با کانفیگ بسیار پایین شما می توانید یک سایت بسیار سنگین و پربازدید را مدیریت کنید.

وجه تسمیه

و علت نام گذاری این فرم ورک به ضنک نیز اشاره به همین موضوع است
</div>
