#!/bin/sh
 
find . -name "*~" -exec rm -r "{}" \;
find . -name ".classpath" -exec rm -r "{}" \;
find . -name ".project" -exec rm -r "{}" \;
find . -name ".settings" -type d -exec rm -r "{}" \;

echo "cleaned up emacs & eclipse trash"

