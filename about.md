# About jEdit-Syntax

This page is adapted from [syntax.jedit.org]
(https://web.archive.org/web/20220617052940/http://syntax.jedit.org/).

## Overview

The jEdit Syntax Package is a syntax highlighting JavaBean. It was previously
maintained by Tom Bradford, and is based on an earlier version of The jEdit
programmer's text editor. jEdit was developed by Slava Pestov and others.

The jEdit Syntax Package is Open Source software, released under an MIT style
license. Because of this, it can be used freely in any software, including
commercial applications.

The recommended Java version for running the jEdit Syntax Package is Java 2
version 1.3. However, it will also run with Java versions as old as 1.1
(as long as Swing 1.1.1 is installed).

The jEdit Syntax Package is easily extensible and immediately provides several
highlighting styles, bracket matching, rectangular editing, macro recording,
and more.

Unlike jEdit, which is a full-blown text editor, the jEdit Syntax Package is
very lightweight, and meant solely for embedding into Java user interfaces.
It does not include some of the nicer features of jEdit, including plugins,
and scripting.

## Related packages

XMLTokenMarker is a simple class that can be used as a TokenMarker plugin for
the jEdit 2.2.1 Syntax Package. I (tom?) wrote it because the HTML
TokenMarker that comes with the syntax highlighting package is very simple,
and isn't fully aware of some XML constructs. This class will be part of the
next official Syntax Package release.

The jEdit 2.2.1 Syntax Package is a stand-alone version of the text control
from an older version of jEdit. It supports features such as syntax
highlighting, bracket matching, rectangular editing, macro recording, and
more.
g
