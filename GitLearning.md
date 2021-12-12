## 文件的添加和提交

在文件夹中创建一个文件（比如这个GitLearning.md）

提示可以使用

```bash
git add <file>
```

也可以使用

```bash
git add -A
```

执行

```bash
git commit -m "提交信息"
```

就可以将文件提交到repository中，提交信息要用英文的双引号括起来

## 文件的修改

可以用

```bash
git status
```

或

```bash
git diff
```

来查看变化

使用

```bash
git checkout -- .
```

