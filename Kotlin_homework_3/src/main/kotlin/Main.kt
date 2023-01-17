open class Picture(val title: String, val author: String)
{
    var creationYear: Int = 0
    var genre: String = ""
    var cost: Double = 0.0

    constructor(title: String, author: String, creationYear: Int) : this(title, author)
    {
        this.creationYear = creationYear
    }

    constructor(title: String, author: String, creationYear: Int, genre: String) : this(title, author, creationYear)
    {
        this.genre = genre
    }

    fun buy(buyPrice: Double)
    {
        this.cost = buyPrice
        println("Картина '${this.title}' успешно куплена по цене ${buyPrice}")
    }

    fun printPictureInfo()
    {
        println("Название: '${this.title}'")
        println("Автор: ${this.author}")
    }
}


class DigitalPicture(title: String, author: String) : Picture(title, author)
{
    var pictureFormat: String = ""
    var technologyType: String = ""

    constructor(title: String, author: String, pictureFormat: String) : this(title, author)
    {
        this.pictureFormat = pictureFormat
    }

    constructor(title: String, author: String, pictureFormat: String, technologyType: String) : this(title, author, pictureFormat)
    {
        this.technologyType = technologyType
    }

    fun rendering()
    {
        println("Картина '${this.title}' прошла процесс рендеринга!")
    }

    fun download()
    {
        println("Картина '${this.title}' загружена на устройство!")
    }
}


class PaintedPicture(title: String, author: String, creationYear: Int, genre: String): Picture(title, author, creationYear, genre)
{
    var technique: String = ""

    constructor(title: String, author: String, creationYear: Int, genre: String, technique: String) : this(title, author, creationYear, genre)
    {
        this.technique = technique
    }
    
    fun restoration()
    {
        println("Картина '${this.title}' была отреставрирована!")
    }

    fun frame()
    {
        println("Картина '${this.title}' была оформлена в рамку с паспорту!")
    }
}


fun main(args: Array<String>)
{
    println("----------Сведения о картине №1----------")
    val pictureOne = PaintedPicture("Мона Лиза", "Леонардо да Винчи",1506, "Портрет", "Масло")

    pictureOne.printPictureInfo()
    println("Год создания: ${pictureOne.creationYear}")
    println("Техника: ${pictureOne.technique}")
    println("Жанр: ${pictureOne.genre}")

    pictureOne.restoration()
    pictureOne.frame()


    println("\n----------Сведения о картине №2----------")
    print("Введите название картины: ")
    var picTitle: String = readln()!!

    print("Введите автора картины: ")
    var picAuthor: String = readln()!!

    val pictureTwo = Picture(picTitle, picAuthor)
    println("Был создан объект класса 'Картина' с названием - '${pictureTwo.title}' и автором - ${pictureTwo.author}")

    println("Желаете купить картину?")
    var answerTwo: String = readln()!!

    if (answerTwo == "да" || answerTwo == "Да" )
    {
        print("Введите цену: ")
        var price: Double = readln()!!.toDouble()

        pictureTwo.buy(price)
    }
    else println("Картина '${pictureTwo.title}' не куплена")


    println("\n----------Сведения о картине №3----------")
    val pictureThree = DigitalPicture("Garden", "Midjourney", "Full HD", "3D")

    pictureThree.printPictureInfo()
    println("Формат изображения: ${pictureThree.pictureFormat}")
    println("Тип технологии: ${pictureThree.technologyType}")
    pictureThree.rendering()

    println("Сохранить картину на Ваше устройство?")
    var answerThree: String = readln()!!

    if (answerThree == "да" || answerThree == "Да" )
    {
        pictureThree.download()
    }
    else println("Картина '${pictureThree.title}' не сохранена на устройство")

}