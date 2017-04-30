## 网易云音乐引导页

花了几天反编译了网易云音乐apk，学到了很多东西，下面单独把引导界面剥离出来.

先看原来网易云音乐引导界面的效果

<img src="https://github.com/OrandNotCN/NeteaseMusicGuide/blob/master/gif/1.gif" width="30%" height="30%"/>

反编译后剥离的效果

<img src="https://github.com/OrandNotCN/NeteaseMusicGuide/blob/master/gif/2.gif" width="30%" height="30%"/>

细微之处还是有点不同的。不过大部分我都还原了，可能动画实现方式有一点不同。
还有个地方我搞不懂，就是viewpager的切换动画被禁止了，这个好像要在自定义viewpager里面操作。这里有点看不懂，于是我就用了淡入淡出的动画效果代替了一下。

总的来说，有几个地方是值得学习的。
一个是适配性方面。UI配合不错，看得出是有算过的。
