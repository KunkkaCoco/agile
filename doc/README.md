[TOC]

#  thinkinjava笔记

## 第1章 对象入门
## 第2章 一切都是对象

### javadoc
2.8.4 @see：引用其他类
所有三种类型的注释文档都可包含@see标记，它允许我们引用其他类里的文档。对于这个标记，javadoc会生成相应的HTML，将其直接链接到其他文档。格式如下：

@see 类名
@see 完整类名
@see 完整类名#方法名

每一格式都会在生成的文档里自动加入一个超链接的“See Also”（参见）条目。注意javadoc不会检查我们指定的超链接，不会验证它们是否有效。

2.8.5 类文档标记
随同嵌入HTML和@see引用，类文档还可以包括用于版本信息以及作者姓名的标记。类文档亦可用于“接口”目的（本书后面会详细解释）。

1. @version
格式如下：
@version 版本信息
其中，“版本信息”代表任何适合作为版本说明的资料。若在javadoc命令行使用了“-version”标记，就会从生成的HTML文档里提取出版本信息。

2. @author
格式如下：
@author 作者信息
其中，“作者信息”包括您的姓名、电子函件地址或者其他任何适宜的资料。若在javadoc命令行使用了“-author”标记，就会专门从生成的HTML文档里提取出作者信息。
可为一系列作者使用多个这样的标记，但它们必须连续放置。全部作者信息会一起存入最终HTML代码的单独一个段落里。

2.8.6 变量文档标记
变量文档只能包括嵌入的HTML以及@see引用。

2.8.7 方法文档标记
除嵌入HTML和@see引用之外，方法还允许使用针对参数、返回值以及违例的文档标记。

1. @param
格式如下：
@param 参数名 说明
其中，“参数名”是指参数列表内的标识符，而“说明”代表一些可延续到后续行内的说明文字。一旦遇到一个新文档标记，就认为前一个说明结束。可使用任意数量的说明，每个参数一个。

2. @return
格式如下：
@return 说明
其中，“说明”是指返回值的含义。它可延续到后面的行内。

3. @exception
有关“违例”（Exception）的详细情况，我们会在第9章讲述。简言之，它们是一些特殊的对象，若某个方法失败，就可将它们“扔出”对象。调用一个方法时，尽管只有一个违例对象出现，但一些特殊的方法也许能产生任意数量的、不同类型的违例。所有这些违例都需要说明。所以，违例标记的格式如下：
@exception 完整类名 说明
其中，“完整类名”明确指定了一个违例类的名字，它是在其他某个地方定义好的。而“说明”（同样可以延续到下面的行）告诉我们为什么这种特殊类型的违例会在方法调用中出现。

4. @deprecated
这是Java 1.1的新特性。该标记用于指出一些旧功能已由改进过的新功能取代。该标记的作用是建议用户不必再使用一种特定的功能，因为未来改版时可能摒弃这一功能。若将一个方法标记为@deprecated，则使用该方法时会收到编译器的警告。

## 第3章 控制程序流程
 总结
本章总结了大多数程序设计语言都具有的基本特性：计算、运算符优先顺序、类型转换以及选择和循环等等。现在，我们作好了相应的准备，可继续向面向对象的程序设计领域迈进。在下一章里，我们将讨论对象的初始化与清除问题，再后面则讲述隐藏的基本实现方法。
## 第4章 初始化和清除
### 主类型的过载

	  void f1(char x) { prt("f1(char)"); }
	  void f1(byte x) { prt("f1(byte)"); }
	  void f1(short x) { prt("f1(short)"); }
	  void f1(int x) { prt("f1(int)"); }
	  void f1(long x) { prt("f1(long)"); }
	  void f1(float x) { prt("f1(float)"); }
	  void f1(double x) { prt("f1(double)"); }

### 对象的创建过程

在一个类里，初始化的顺序是由变量在类内的定义顺序决定的。即使变量定义大量遍布于方法定义的中间，那些变量仍会在调用任何方法之前得到初始化——甚至在构建器调用之前

请考虑一个名为Dog的类：

1. 类型为Dog的一个对象首次创建时，或者Dog类的static方法／static字段首次访问时，Java解释器必须找到Dog.class（在事先设好的类路径里搜索）。
2. 找到Dog.class后（它会创建一个Class对象，这将在后面学到），它的所有static初始化模块都会运行。因此，static初始化仅发生一次——在Class对象首次载入的时候。
3. 创建一个new Dog()时，Dog对象的构建进程首先会在内存堆（Heap）里为一个Dog对象分配足够多的存储空间。
4. 这种存储空间会清为零，将Dog中的所有基本类型设为它们的默认值（零用于数字，以及boolean和char的等价设定）。
5. 进行字段定义时发生的所有初始化都会执行。
6. 执行构建器。正如第6章将要讲到的那样，这实际可能要求进行相当多的操作，特别是在涉及继承的时候。

new一个对象的时候时候先初始化静态变量然后是成员变量， 都按变量的顺序初始化，然后构造函数返回对象。


总结：
作为初始化的一种具体操作形式，构建器应使大家明确感受到在语言中进行初始化的重要性。与C++的程序设计一样，判断一个程序效率如何，关键是看是否由于变量的初始化不正确而造成了严重的编程错误（臭虫）。这些形式的错误很难发现，而且类似的问题也适用于不正确的清除或收尾工作。由于构建器使我们能保证正确的初始化和清除（若没有正确的构建器调用，编译器不允许对象创建），所以能获得完全的控制权和安全性。
在C++中，与“构建”相反的“破坏”（Destruction）工作也是相当重要的，因为用new创建的对象必须明确地清除。在Java中，垃圾收集器会自动为所有对象释放内存，所以Java中等价的清除方法并不是经常都需要用到的。如果不需要类似于构建器的行为，Java的垃圾收集器可以极大简化编程工作，而且在内存的管理过程中增加更大的安全性。有些垃圾收集器甚至能清除其他资源，比如图形和文件句柄等。然而，垃圾收集器确实也增加了运行期的开销。但这种开销到底造成了多大的影响却是很难看出的，因为到目前为止，Java解释器的总体运行速度仍然是比较慢的。随着这一情况的改观，我们应该能判断出垃圾收集器的开销是否使Java不适合做一些特定的工作（其中一个问题是垃圾收集器不可预测的性质）。
由于所有对象都肯定能获得正确的构建，所以同这儿讲述的情况相比，构建器实际做的事情还要多得多。特别地，当我们通过“创作”或“继承”生成新类的时候，对构建的保证仍然有效，而且需要一些附加的语法来提供对它的支持。大家将在以后的章节里详细了解创作、继承以及它们对构建器造成的影响。
## 第5章 隐藏实施过程
总结：
对于任何关系，最重要的一点都是规定好所有方面都必须遵守的界限或规则。创建一个库时，相当于建立了同那个库的用户（即“客户程序员”）的一种关系——那些用户属于另外的程序员，可能用我们的库自行构建一个应用程序，或者用我们的库构建一个更大的库。
如果不制订规则，客户程序员就可以随心所欲地操作一个类的所有成员，无论我们本来愿不愿意其中的一些成员被直接操作。所有东西都在别人面前都暴露无遗。
本章讲述了如何构建类，从而制作出理想的库。首先，我们讲述如何将一组类封装到一个库里。其次，我们讲述类如何控制对自己成员的访问。
一般情况下，一个C程序项目会在50K到100K行代码之间的某个地方开始中断。这是由于C仅有一个“命名空间”，所以名字会开始互相抵触，从而造成额外的管理开销。而在Java中，package关键字、包命名方案以及import关键字为我们提供对名字的完全控制，所以命名冲突的问题可以很轻易地得到避免。
有两方面的原因要求我们控制对成员的访问。第一个是防止用户接触那些他们不应碰的工具。对于数据类型的内部机制，那些工具是必需的。但它们并不属于用户接口的一部分，用户不必用它来解决自己的特定问题。所以将方法和字段变成“私有”（private）后，可极大方便用户。因为他们能轻易看出哪些对于自己来说是最重要的，以及哪些是自己需要忽略的。这样便简化了用户对一个类的理解。
进行访问控制的第二个、也是最重要的一个原因是：允许库设计者改变类的内部工作机制，同时不必担心它会对客户程序员产生什么影响。最开始的时候，可用一种方法构建一个类，后来发现需要重新构建代码，以便达到更快的速度。如接口和实施细节早已进行了明确的分隔与保护，就可以轻松地达到自己的目的，不要求用户改写他们的代码。
利用Java中的访问指示符，可有效控制类的创建者。那个类的用户可确切知道哪些是自己能够使用的，哪些则是可以忽略的。但更重要的一点是，它可确保没有任何用户能依赖一个类的基础实施机制的任何部分。作为一个类的创建者，我们可自由修改基础的实施细节，这一改变不会对客户程序员产生任何影响，因为他们不能访问类的那一部分。
有能力改变基础的实施细节后，除了能在以后改进自己的设置之外，也同时拥有了“犯错误”的自由。无论当初计划与设计时有多么仔细，仍然有可能出现一些失误。由于知道自己能相当安全地犯下这种错误，所以可以放心大胆地进行更多、更自由的试验。这对自己编程水平的提高是很有帮助的，使整个项目最终能更快、更好地完成。
一个类的公共接口是所有用户都能看见的，所以在进行分析与设计的时候，这是应尽量保证其准确性的最重要的一个部分。但也不必过于紧张，少许的误差仍然是允许的。若最初设计的接口存在少许问题，可考虑添加更多的方法，只要保证不删除客户程序员已在他们的代码里使用的东西。

## 第6章 类再生
### mvn test 的时候每一个测试方法都默认调用一次类的构造方法
#### 继承初始化

    Beetle main执行过程
    1.初始化父类static变量
    2.初始化本身 static变量
    3.初始化父类非静态成员变量
    4.调用父类构造函数
    5.初始化本身非静态成员变量
    6.调用构造函数
 总结：
    对Beetle运行Java时，发生的第一件事情是装载程序到外面找到那个类。在装载过程中，装载程序注意它有一个基础类（即extends关键字要表达的意思），所以随之将其载入。无论是否准备生成那个基础类的一个对象，这个过程都会发生（请试着将对象的创建代码当作注释标注出来，自己去证实）。
若基础类含有另一个基础类，则另一个基础类随即也会载入，以此类推。接下来，会在根基础类（此时是Insect）执行static初始化，再在下一个衍生类执行，以此类推。保证这个顺序是非常关键的，因为衍生类的初始化可能要依赖于对基础类成员的正确初始化。
此时，必要的类已全部装载完毕，所以能够创建对象。首先，这个对象中的所有基本数据类型都会设成它们的默认值，而将对象句柄设为null。随后会调用基础类构建器。在这种情况下，调用是自动进行的。但也完全可以用super来自行指定构建器调用（就象在Beetle()构建器中的第一个操作一样）。基础类的构建采用与衍生类构建器完全相同的处理过程。基础顺构建器完成以后，实例变量会按本来的顺序得以初始化。最后，执行构建器剩余的主体部分。
## 第7章 多形性

“多形性”意味着“不同的形式”。在面向对象的程序设计中，我们有相同的外观（基础类的通用接口）以及使用那个外观的不同形式：动态绑定或组织的、不同版本的方法。
通过这一章的学习，大家已知道假如不利用数据抽象以及继承技术，就不可能理解、甚至去创建多形性的一个例子。多形性是一种不可独立应用的特性（就象一个switch语句），只可与其他元素协同使用。我们应将其作为类总体关系的一部分来看待。人们经常混淆Java其他的、非面向对象的特性，比如方法过载等，这些特性有时也具有面向对象的某些特征。但不要被愚弄：如果以后没有绑定，就不成其为多形性。
为使用多形性乃至面向对象的技术，特别是在自己的程序中，必须将自己的编程视野扩展到不仅包括单独一个类的成员和消息，也要包括类与类之间的一致性以及它们的关系。尽管这要求学习时付出更多的精力，但却是非常值得的，因为只有这样才可真正有效地加快自己的编程速度、更好地组织代码、更容易做出包容面广的程序以及更易对自己的代码进行维护与扩展。


## 第8章 对象的容纳

8.8 总结
下面复习一下由标准Java（1.0和1.1）库提供的集合（BitSet未包括在这里，因为它更象一种负有特殊使命的类）：

1. 数组包含了对象的数字化索引。它容纳的是一种已知类型的对象，所以在查找一个对象时，不必对结果进行造型处理。数组可以是多维的，而且能够容纳基本数据类型。但是，一旦把它创建好以后，大小便不能变化了。
2. Vector（矢量）也包含了对象的数字索引——可将数组和Vector想象成随机访问集合。当我们加入更多的元素时，Vector能够自动改变自身的大小。但Vector只能容纳对象的句柄，所以它不可包含基本数据类型；而且将一个对象句柄从集合中取出来的时候，必须对结果进行造型处理。
3. Hashtable（散列表）属于Dictionary（字典）的一种类型，是一种将对象（而不是数字）同其他对象关联到一起的方式。散列表也支持对对象的随机访问，事实上，它的整个设计方案都在突出访问的“高速度”。
4. Stack（堆栈）是一种“后入先出”（LIFO）的队列。

若你曾经熟悉数据结构，可能会疑惑为何没看到一套更大的集合。从功能的角度出发，你真的需要一套更大的集合吗？对于Hashtable，可将任何东西置入其中，并以非常快的速度检索；对于Enumeration（枚举），可遍历一个序列，并对其中的每个元素都采取一个特定的操作。那是一种功能足够强劲的工具。
但Hashtable没有“顺序”的概念。Vector和数组为我们提供了一种线性顺序，但若要把一个元素插入它们任何一个的中部，一般都要付出“惨重”的代价。除此以外，队列、拆散队列、优先级队列以及树都涉及到元素的“排序”——并非仅仅将它们置入，以便以后能按线性顺序查找或移动它们。这些数据结构也非常有用，这也正是标准C++中包含了它们的原因。考虑到这个原因，只应将标准Java库的集合看作自己的一个起点。而且倘若必须使用Java 1.0或1.1，则可在需要超越它们的时候使用JGL。
如果能使用Java 1.2，那么只使用新集合即可，它一般能满足我们的所有需要。注意本书在Java 1.1身上花了大量篇幅，所以书中用到的大量集合都是只能在Java1.1中用到的那些：Vector和Hashtable。就目前来看，这是一个不得以而为之的做法。但是，这样处理亦可提供与老Java代码更出色的向后兼容能力。若要用Java1.2写新代码，新的集合往往能更好地为你服务。

## 第9章 违例差错控制

违例准则 , 用违例做下面这些事情：

1. 解决问题并再次调用造成违例的方法。
2. 平息事态的发展，并在不重新尝试方法的前提下继续。
3. 计算另一些结果，而不是希望方法产生的结果。
4. 在当前环境中尽可能解决问题，以及将相同的违例重新“掷”出一个更高级的环境。
5. 在当前环境中尽可能解决问题，以及将不同的违例重新“掷”出一个更高级的环境。
6. 中止程序执行。
7. 简化编码。若违例方案使事情变得更加复杂，那就会令人非常烦恼，不如不用。
8. 使自己的库和程序变得更加安全。这既是一种“短期投资”（便于调试），也是一种“长期投资”（改善应用程序的健壮性）

9.9 总结
通过先进的错误纠正与恢复机制，我们可以有效地增强代码的健壮程度。对我们编写的每个程序来说，错误恢复都属于一个基本的考虑目标。它在Java中显得尤为重要，因为该语言的一个目标就是创建不同的程序组件，以便其他用户（客户程序员）使用。为构建一套健壮的系统，每个组件都必须非常健壮。
在Java里，违例控制的目的是使用尽可能精简的代码创建大型、可靠的应用程序，同时排除程序里那些不能控制的错误。
违例的概念很难掌握。但只有很好地运用它，才可使自己的项目立即获得显著的收益。Java强迫遵守违例所有方面的问题，所以无论库设计者还是客户程序员，都能够连续一致地使用它。

## 第10章 java IO系统

10.10 总结
Java IO流库能满足我们的许多基本要求：可以通过控制台、文件、内存块甚至因特网（参见第15章）进行读写。可以创建新的输入和输出对象类型（通过从InputStream和OutputStream继承）。向一个本来预期为收到字串的方法传递一个对象时，由于Java已限制了“自动类型转换”，所以会自动调用toString()方法。而我们可以重新定义这个toString()，扩展一个数据流能接纳的对象种类。
在IO数据流库的联机文档和设计过程中，仍有些问题没有解决。比如当我们打开一个文件以便输出时，完全可以指定一旦有人试图覆盖该文件就“掷”出一个违例——有的编程系统允许我们自行指定想打开一个输出文件，但唯一的前提是它尚不存在。但在Java中，似乎必须用一个File对象来判断某个文件是否存在，因为假如将其作为FileOutputStream或者FileWriter打开，那么肯定会被覆盖。若同时指定文件和目录路径，File类设计上的一个缺陷就会暴露出来，因为它会说“不要试图在单个类里做太多的事情”！
IO流库易使我们混淆一些概念。它确实能做许多事情，而且也可以移植。但假如假如事先没有吃透装饰器方案的概念，那么所有的设计都多少带有一点盲目性质。所以不管学它还是教它，都要特别花一些功夫才行。而且它并不完整：没有提供对输出格式化的支持，而其他几乎所有语言的IO包都提供了这方面的支持（这一点没有在Java 1.1里得以纠正，它完全错失了改变库设计方案的机会，反而增添了更特殊的一些情况，使复杂程度进一步提高）。Java 1.1转到那些尚未替换的IO库，而不是增加新库。而且库的设计人员似乎没有很好地指出哪些特性是不赞成的，哪些是首选的，造成库设计中经常都会出现一些令人恼火的反对消息。
然而，一旦掌握了装饰器方案，并开始在一些较为灵活的环境使用库，就会认识到这种设计的好处。到那个时候，为此多付出的代码行应该不至于使你觉得太生气。


## 第11章 运行期类型检查

11.4 总结
利用RTTI可根据一个匿名的基础类句柄调查出类型信息。但正是由于这个原因，新手们极易误用它，因为有些时候多形性方法便足够了。对那些以前习惯程序化编程的人来说，极易将他们的程序组织成一系列switch语句。他们可能用RTTI做到这一点，从而在代码开发和维护中损失多形性技术的重要价值。Java的要求是让我们尽可能地采用多形性，只有在极特别的情况下才使用RTTI。
但为了利用多形性，要求我们拥有对基础类定义的控制权，因为有些时候在程序范围之内，可能发现基础类并未包括我们想要的方法。若基础类来自一个库，或者由别的什么东西控制着，RTTI便是一种很好的解决方案：可继承一个新类型，然后添加自己的额外方法。在代码的其他地方，可以侦测自己的特定类型，并调用那个特殊的方法。这样做不会破坏多形性以及程序的扩展能力，因为新类型的添加不要求查找程序中的switch语句。但在需要新特性的主体中添加新代码时，就必须用RTTI侦测自己特定的类型。
从某个特定类的利益的角度出发，在基础类里加入一个特性后，可能意味着从那个基础类衍生的其他所有类都必须获得一些无意义的“鸡肋”。这使得接口变得含义模糊。若有人从那个基础类继承，且必须覆盖抽象方法，这一现象便会使他们陷入困扰。比如现在用一个类结构来表示乐器（Instrument）。假定我们想清洁管弦乐队中所有适当乐器的通气音栓（Spit Valve），此时的一个办法是在基础类Instrument中置入一个ClearSpitValve()方法。但这样做会造成一个误区，因为它暗示着打击乐器和电子乐器中也有音栓。针对这种情况，RTTI提供了一个更合理的解决方案，可将方法置入特定的类中（此时是Wind，即“通气口”）——这样做是可行的。但事实上一种更合理的方案是将prepareInstrument()置入基础类中。初学者刚开始时往往看不到这一点，一般会认定自己必须使用RTTI。
最后，RTTI有时能解决效率问题。若代码大量运用了多形性，但其中的一个对象在执行效率上很有问题，便可用RTTI找出那个类型，然后写一段适当的代码，改进其效率。


## 12.5 传递和返回对象

由于Java中的所有东西都是句柄，而且由于每个对象都是在内存堆中创建的——只有不再需要的时候，才会当作垃圾收集掉，所以对象的操作方式发生了变化，特别是在传递和返回对象的时候。举个例子来说，在C和C++中，如果想在一个方法里初始化一些存储空间，可能需要请求用户将那片存储区域的地址传递进入方法。否则就必须考虑由谁负责清除那片区域。因此，这些方法的接口和对它们的理解就显得要复杂一些。但在Java中，根本不必关心由谁负责清除，也不必关心在需要一个对象的时候它是否仍然存在。因为系统会为我们照料一切。我们的程序可在需要的时候创建一个对象。而且更进一步地，根本不必担心那个对象的传输机制的细节：只需简单地传递句柄即可。有些时候，这种简化非常有价值，但另一些时候却显得有些多余。
可从两个方面认识这一机制的缺点：
(1) 肯定要为额外的内存管理付出效率上的损失（尽管损失不大），而且对于运行所需的时间，总是存在一丝不确定的因素（因为在内存不够时，垃圾收集器可能会被强制采取行动）。对大多数应用来说，优点显得比缺点重要，而且部分对时间要求非常苛刻的段落可以用native方法写成（参见附录A）。
(2) 别名处理：有时会不慎获得指向同一个对象的两个句柄。只有在这两个句柄都假定指向一个“明确”的对象时，才有可能产生问题。对这个问题，必须加以足够的重视。而且应该尽可能地“克隆”一个对象，以防止另一个句柄被不希望的改动影响。除此以外，可考虑创建“不可变”对象，使它的操作能返回同种类型或不同种类型的一个新对象，从而提高程序的执行效率。但千万不要改变原始对象，使对那个对象别名的其他任何方面都感觉不出变化。

有些人认为Java的克隆是一个笨拙的家伙，所以他们实现了自己的克隆方案（注释⑤），永远杜绝调用Object.clone()方法，从而消除了实现Cloneable和捕获CloneNotSupportException违例的需要。这一做法是合理的，而且由于clone()在Java标准库中很少得以支持，所以这显然也是一种“安全”的方法。只要不调用Object.clone()，就不必实现Cloneable或者捕获违例，所以那看起来也是能够接受的。

⑤：Doug Lea特别重视这个问题，并把这个方法推荐给了我，他说只需为每个类都创建一个名为duplicate()的函数即可。

Java中一个有趣的关键字是byvalue（按值），它属于那些“保留但未实现”的关键字之一。在理解了别名和克隆问题以后，大家可以想象byvalue最终有一天会在Java中用于实现一种自动化的本地副本。这样做可以解决更多复杂的克隆问题，并使这种情况下的编写的代码变得更加简单和健壮。

## 14 多线程
14.6 总结
何时使用多线程技术，以及何时避免用它，这是我们需要掌握的重要课题。骼它的主要目的是对大量任务进行有序的管理。通过多个任务的混合使用，可以更有效地利用计算机资源，或者对用户来说显得更方便。资源均衡的经典问题是在IO等候期间如何利用CPU。至于用户方面的方便性，最经典的问题就是如何在一个长时间的下载过程中监视并灵敏地反应一个“停止”（stop）按钮的按下。
多线程的主要缺点包括：
(1) 等候使用共享资源时造成程序的运行速度变慢。
(2) 对线程进行管理要求的额外CPU开销。
(3) 复杂程度无意义的加大，比如用独立的线程来更新数组内每个元素的愚蠢主意。
(4) 漫长的等待、浪费精力的资源竞争以及死锁等多线程症状。
线程另一个优点是它们用“轻度”执行切换（100条指令的顺序）取代了“重度”进程场景切换（1000条指令）。由于一个进程内的所有线程共享相同的内存空间，所以“轻度”场景切换只改变程序的执行和本地变量。而在“重度”场景切换时，一个进程的改变要求必须完整地交换内存空间。
线程处理看来好象进入了一个全新的领域，似乎要求我们学习一种全新的程序设计语言——或者至少学习一系列新的语言概念。由于大多数微机操作系统都提供了对线程的支持，所以程序设计语言或者库里也出现了对线程的扩展。不管在什么情况下，涉及线程的程序设计：
(1) 刚开始会让人摸不着头脑，要求改换我们传统的编程思路；
(2) 其他语言对线程的支持看来是类似的。所以一旦掌握了线程的概念，在其他环境也不会有太大的困难。尽管对线程的支持使Java语言的复杂程度多少有些增加，但请不要责怪Java。毕竟，利用线程可以做许多有益的事情。
多个线程可能共享同一个资源（比如一个对象里的内存），这是运用线程时面临的最大的一个麻烦。必须保证多个线程不会同时试图读取和修改那个资源。这要求技巧性地运用synchronized（同步）关键字。它是一个有用的工具，但必须真正掌握它，因为假若操作不当，极易出现死锁。
除此以外，运用线程时还要注意一个非常特殊的问题。由于根据Java的设计，它允许我们根据需要创建任意数量的线程——至少理论上如此（例如，假设为一项工程方面的有限元素分析创建数以百万的线程，这对Java来说并非实际）。然而，我们一般都要控制自己创建的线程数量的上限。因为在某些情况下，大量线程会将场面变得一团糟，所以工作都会几乎陷于停顿。临界点并不象对象那样可以达到几千个，而是在100以下。一般情况下，我们只创建少数几个关键线程，用它们解决某个特定的问题。这时数量的限制问题不大。但在较常规的一些设计中，这一限制确实会使我们感到束手束脚。
大家要注意线程处理中一个不是十分直观的问题。由于采用了线程“调度”机制，所以通过在run()的主循环中插入对sleep()的调用，一般都可以使自己的程序运行得更快一些。这使它对编程技巧的要求非常高，特别是在更长的延迟似乎反而能提高性能的时候。当然，之所以会出现这种情况，是由于在正在运行的线程准备进入“休眠”状态之前，较短的延迟可能造成“sleep()结束”调度机制的中断。这便强迫调度机制将其中止，并于稍后重新启动，以便它能做完自己的事情，再进入休眠状态。必须多想一想，才能意识到事情真正的麻烦程度。
本章遗漏的一件事情是一个动画例子，这是目前程序片最流行的一种应用。然而，Java JDK配套提供了解决这个问题的一整套方案（并可播放声音），大家可到java.sun.com的演示区域下载。此外，我们完全有理由相信未来版本的Java会提供更好的动画支持——尽管目前的Web涌现出了与传统方式完全不同的非Java、非程序化的许多动画方案。如果想系统学习Java动画的工作原理，可参考《Core Java——核心Java》一书，由Cornell&Horstmann编著，Prentice-Hall于1997年出版。若欲更深入地了解线程处理，请参考《Concurrent Programming in Java——Java中的并发编程》，由Doug Lea编著，Addison-Wiseley于1997年出版；或者《Java Threads——Java线程》，Oaks&Wong编著，O'Reilly于1997年出版。